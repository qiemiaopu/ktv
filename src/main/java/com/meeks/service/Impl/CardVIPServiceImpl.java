package com.meeks.service.Impl;

import com.meeks.base.DaoSupportImpl;
import com.meeks.domain.CardVIP;
import com.meeks.service.CardVIPService;
import org.springframework.stereotype.Service;

/**
 * Created by maple on 16/3/6.
 */
@Service
public class CardVIPServiceImpl extends DaoSupportImpl<CardVIP> implements CardVIPService {
    @Override
    public CardVIP getLast() {
        return (CardVIP) getSession().createQuery("FROM CardVIP ORDER BY id DESC")//
                .setMaxResults(1)//
                .uniqueResult();
    }
}
