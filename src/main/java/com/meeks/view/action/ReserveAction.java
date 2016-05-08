package com.meeks.view.action;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.meeks.base.BaseAction;
import com.meeks.domain.House;
import com.meeks.domain.Reserve;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class ReserveAction extends BaseAction<Reserve> {

    public String addUI() throws Exception {
        House house = houseService.getById(model.getHouseId());
        ActionContext.getContext().getValueStack().push(house);
        return "saveUI";
    }

    public String add() throws Exception {
        Date curDate = new Date();
        model.setStartTime(curDate);
        model.setEndTime(DateUtils.addHours(curDate, hours));
        reserveService.save(model);

        House house = houseService.getById(model.getHouseId());
        house.setStatus(House.RESERVED);
        house.setReserveId(model.getId());
        houseService.update(house);
        return "toHouseList";
    }

    public String show() throws Exception {
        Reserve reserve = reserveService.getById(model.getId());
        ActionContext.getContext().getValueStack().push(reserve);
        return "show";
    }

    private Integer hours;

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }
}
