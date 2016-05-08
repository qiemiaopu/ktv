package com.meeks.service;

import com.meeks.base.DaoSupport;
import com.meeks.domain.CardVIP;

/**
 * Created by maple on 16/3/6.
 */
public interface CardVIPService extends DaoSupport<CardVIP> {
    CardVIP getLast();
}
