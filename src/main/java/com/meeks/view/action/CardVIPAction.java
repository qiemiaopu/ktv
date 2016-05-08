package com.meeks.view.action;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.meeks.base.BaseAction;
import com.meeks.domain.Bill;
import com.meeks.domain.CardVIP;
import com.meeks.util.QueryHelper;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class CardVIPAction extends BaseAction<CardVIP> {

    public String list() throws Exception {
        new QueryHelper(CardVIP.class, "r")//
                .addCondition(!StringUtils.isEmpty(model.getOwner()), "r.owner like '%" + model.getOwner() + "%'")//
                .addCondition(!StringUtils.isEmpty(model.getNumber()), "r.number like '%" + model.getNumber() + "%'")//
                .addCondition((model.getPhone() != null), "r.phone like '%" + model.getPhone() + "%'")//
                .push(cardVIPService);
        return "list";
    }

    public String addUI() throws Exception {
        return "addUI";
    }

    public String add() throws Exception {
        CardVIP lastBean = cardVIPService.getLast();
        String lastNumber;
        if (lastBean == null) {
            lastNumber = "VIPNo.1000";
        } else {
            lastNumber = lastBean.getNumber();
        }
        for (int i = 0; i < count; i++) {
            CardVIP bean = new CardVIP();
            String number = "VIPNo.";
            Integer tail = Integer.parseInt(lastNumber.split("\\.")[1]) + i + 1;
            int length = 3 + String.valueOf(tail).length();
            for (int j = 0; j < 11 - length; j++) {
                number += "0";
            }
            bean.setNumber(number + tail);
            cardVIPService.save(bean);
        }
        return "toList";
    }

    public String delete() throws Exception {
        cardVIPService.delete(model.getId());
        return "toList";
    }

    public String editUI() throws Exception {
        CardVIP cardVIP = cardVIPService.getById(model.getId());
        ActionContext.getContext().getValueStack().push(cardVIP);
        return "saveUI";
    }

    public String edit() throws Exception {
        CardVIP cardVIP = cardVIPService.getById(model.getId());
        cardVIP.setPhone(model.getPhone());
        cardVIP.setOwner(model.getOwner());
        cardVIPService.update(cardVIP);
        return "toList";
    }

    public String buyUI() throws Exception {
        CardVIP cardVIP = cardVIPService.getById(model.getId());
        ActionContext.getContext().getValueStack().push(cardVIP);
        return "buyUI";
    }

    public String buy() throws Exception {
        CardVIP cardVIP = cardVIPService.getById(model.getId());
        cardVIP.setPhone(model.getPhone());
        cardVIP.setCreateTime(new Date());
        cardVIP.setOwner(model.getOwner());
        cardVIPService.update(cardVIP);

        billService.add(new Bill(50D, "会员卡 " + cardVIP.getNumber() + " 入账."));
        return "toList";
    }


    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
