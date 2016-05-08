package com.meeks.view.action;

import com.meeks.base.BaseAction;
import com.meeks.domain.House;
import com.meeks.domain.Reserve;
import com.meeks.util.QueryHelper;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
@Scope("prototype")
public class ReserveAction extends BaseAction<Reserve> {

    /**
     * 列表
     */
    public String list() throws Exception {
        String houseName = model.getHouse().getName();
        House house = null;
        if (houseName != null) {
            house = houseService.getByName(houseName);
        }
        new QueryHelper(Reserve.class, "r")//
                .addCondition((houseName != null), "r.houseId = ?", house.getId())//
                .addCondition((model.getName() != null), "r.name = ?", model.getName())//
                .addCondition((model.getPhone() != null), "r.phone like ?%", model.getPhone())//
                .addCondition((model.getEndTime() != null), "r.endTime < ?", DateUtils.addHours(new Date(), 1))//
                .preparePageBean(reserveService, pageNum, pageSize);
        return "list";
    }

    public String addUI() throws Exception {
        return "saveUI";
    }

    public String add() throws Exception {
        reserveService.save(model);
        return null;
    }

    public String delete() throws Exception {
        reserveService.delete(model.getId());
        return "toList";
    }

    private String editUI() throws Exception {
        Reserve reserve = reserveService.getById(model.getId());
        ActionContext.getContext().getValueStack().push(reserve);
        return "saveUI";
    }

    private String edit() throws Exception {
        Reserve reserve = reserveService.getById(model.getId());
        reserve.setName(model.getName());
        reserve.setPhone(model.getPhone());
        reserve.setStartTime(model.getStartTime());
        reserveService.update(reserve);
        return "toList";
    }


}
