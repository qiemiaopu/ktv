package com.meeks.util;

import com.meeks.domain.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class Installer {

    @Resource
    private SessionFactory sessionFactory;

    /**
     * 执行安装
     */
    @Transactional
    public void install() {
        Session session = sessionFactory.getCurrentSession();

        // ==============================================================
        // 保存超级管理员用户
        User user = new User();
        user.setLoginName("admin");
        user.setMd5Password(DigestUtils.md5Hex("admin"));
        session.save(user); // 保存

    }

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(
                "applicationContext.xml")) {
            Installer installer = (Installer) ac.getBean("installer");
            installer.install();
        }
    }
}
