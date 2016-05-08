package com.meeks.service.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import com.meeks.base.DaoSupportImpl;
import com.meeks.domain.Bill;
import com.meeks.domain.House;
import com.meeks.service.BillService;
import com.meeks.service.HouseService;

@Service
public class HouseServiceImpl extends DaoSupportImpl<House> implements HouseService {
    private SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日HH时mm分");

    @Resource
    private BillService billService;

    @Override
    public boolean open(Integer houseId, Integer hours) {
        Date currDate = new Date();
        House bean = getById(houseId);
        if (bean == null)
            return false;
        bean.setStatus(1);
        bean.setStartTime(currDate);
        bean.setEndTime(DateUtils.addHours(currDate, hours));
        bean.setAction1(sdf.format(currDate) + " 开台;");
        update(bean);
        billService.add(new Bill(bean.getValue() * hours, "开台 " + bean.getName() + " 入账."));
        return true;
    }

    @Override
    public boolean clean(Integer houseId) {
        Date currDate = new Date();
        House bean = getById(houseId);
        if (bean == null)
            return false;
        bean.setStatus(3);
        bean.setStartTime(currDate);
        bean.setEndTime(null);
        bean.setAction1(bean.getAction1() + sdf.format(currDate) + " 开始清理;");
        update(bean);
        return true;
    }

    @Override
    public boolean useble(Integer houseId) {
        House bean = getById(houseId);
        if (bean == null)
            return false;
        bean.setStatus(House.EMPTY);
        bean.setStartTime(null);
        bean.setEndTime(null);
        bean.setAction1("");
        update(bean);
        return true;
    }

    @Override
    public boolean delay(Integer houseID, Integer hours) {
        House bean = getById(houseID);
        if (bean == null)
            return false;
        bean.setEndTime(DateUtils.addHours(bean.getEndTime(), hours));
        bean.setAction1(bean.getAction1() + sdf.format(new Date()) + "续费" + hours + "小时;");
        update(bean);
        billService.add(new Bill(bean.getValue(), bean.getName() + "续费" + hours + "小时."));
        return true;
    }

    @Override
    public House getByName(String name) {
        return (House) getSession().createQuery("FROM House WHERE House.name = :name")//
                .setParameter("name", name)//
                .uniqueResult();
    }
}
