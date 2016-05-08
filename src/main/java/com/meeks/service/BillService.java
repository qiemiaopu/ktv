package com.meeks.service;

import com.meeks.base.DaoSupport;
import com.meeks.domain.Bill;

/**
 * Created by maple on 16/3/6.
 */
public interface BillService extends DaoSupport<Bill> {
    void add(Bill bean);
}
