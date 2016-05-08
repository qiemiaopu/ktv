package com.meeks.view.action;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.meeks.base.BaseAction;
import com.meeks.domain.House;
import com.meeks.util.QueryHelper;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class HouseAction extends BaseAction<House> {

    /**
     * 列表
     */
    public String list() throws Exception {
        Integer status = model.getStatus();
        Integer type = model.getType();
        new QueryHelper(House.class, "h")//
                .addCondition((type != null && type != 0), "h.type = ?", type)//
                .addCondition((status != null && status != -1 && status != House.EXPIRE), "h.status = ?", status)//
                .addCondition((status != null && status != -1 && status == House.EXPIRE), "h.endTime < ?", DateUtils.addHours(new Date(), 1))//
                .addOrderProperty("h.id", false)//
                .push(houseService);
        return "list";
    }

    public String addUI() throws Exception {
        return "saveUI";
    }

    public String add() throws Exception {
        model.setStatus(0);//TODO 前台根据类型给出默认价格
        houseService.save(model);
        return "toList";
    }

    public String delete() throws Exception {
        houseService.delete(model.getId());
        return "toList";
    }

    public String editUI() throws Exception {
        House house = houseService.getById(model.getId());
        ActionContext.getContext().getValueStack().push(house);
        return "editUI";
    }

    public String edit() throws Exception {
        House house = houseService.getById(model.getId());
        house.setName(model.getName());
        house.setType(model.getType());
        house.setDiscount(model.getDiscount());
        houseService.update(house);
        return "toList";
    }

    public String handleUI() throws Exception {
        House house = houseService.getById(model.getId());
        house.setStatus(model.getStatus());
        ActionContext.getContext().getValueStack().push(house);
        return "handleUI";
    }

    public String handle() throws Exception {
        Integer houseId = model.getId();
        switch (model.getStatus()) {
            case House.EMPTY: // 清理完
                houseService.useble(houseId);
                break;
            case House.USING: // 开台
                houseService.open(houseId, hours);
                break;
            case House.CLEANING: // 开始清理
                houseService.clean(houseId);
                break;
            case 5: // 续费
                houseService.delay(houseId, hours);
                break;
            default:
        }
        return "toList";
    }


    ////////////////////////////////////////////////
    private Integer hours;

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }
}
