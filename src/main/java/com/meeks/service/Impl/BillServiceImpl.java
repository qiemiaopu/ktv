package com.meeks.service.Impl;

import com.meeks.base.DaoSupportImpl;
import com.meeks.domain.Bill;
import com.meeks.service.BillService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by maple on 16/3/6.
 */
@Service
public class BillServiceImpl extends DaoSupportImpl<Bill> implements BillService {
    @Override
    public void add(Bill bean) {
        bean.setCreateDate(new Date());
        save(bean);
    }
}
