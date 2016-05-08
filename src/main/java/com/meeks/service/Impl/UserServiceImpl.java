package com.meeks.service.Impl;

import com.meeks.base.DaoSupportImpl;
import com.meeks.domain.User;
import com.meeks.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

/**
 * Created by maple on 16/3/6.
 */
@Service
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService {
    @Override
    public User findByLoginNameAndPassword(String loginName, String password) {
        // 使用密码的MD5摘要进行对比
        String md5Digest = DigestUtils.md5Hex(password);
        return (User) getSession().createQuery(//
                "FROM User u WHERE u.loginName=? AND u.md5Password=?")//
                .setParameter(0, loginName)//
                .setParameter(1, md5Digest)//
                .uniqueResult();
    }

    @Override
    public User findByLoginName(String loginName) {
        return (User) getSession().createQuery(//
                "FROM User u WHERE u.loginName=?")//
                .setParameter(0, loginName)//
                .uniqueResult();
    }
}
