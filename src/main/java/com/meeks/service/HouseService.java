package com.meeks.service;

import com.meeks.base.DaoSupport;
import com.meeks.domain.House;

/**
 * Created by maple on 16/3/6.
 */
public interface HouseService extends DaoSupport<House> {
    boolean open(Integer houseId, Integer hours);

    boolean clean(Integer houseId);

    boolean useble(Integer houseId);

    House getByName(String name);

    boolean delay(Integer houseID, Integer hours);

}
