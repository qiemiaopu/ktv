package com.meeks.service;

import com.meeks.base.DaoSupport;
import com.meeks.domain.User;

/**
 * Created by maple on 16/3/6.
 */
public interface UserService extends DaoSupport<User> {
    User findByLoginNameAndPassword(String loginName,String password);
    User findByLoginName(String loginName);
}
