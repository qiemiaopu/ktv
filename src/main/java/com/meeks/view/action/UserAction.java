package com.meeks.view.action;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.meeks.base.BaseAction;
import com.meeks.domain.User;
import com.meeks.util.QueryHelper;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

    /**
     * 列表
     */
    public String list() throws Exception {
        Long phone = model.getPhone();
        String name = model.getName();
        new QueryHelper(User.class, "u")//
                .addCondition((phone != null), "u.phone LIKE '%" + phone + "%'")//
                .addCondition((!StringUtils.isEmpty(name)), "u.name LIKE '%" + name + "%'")//
                .addOrderProperty("u.id", true)//
                .push(userService);
        return "list";
    }

    /**
     * 删除
     */
    public String delete() throws Exception {
        userService.delete(model.getId());
        return "toList";
    }

    /**
     * 修改(重置密码)
     */
    public String edit() throws Exception {
        // 1，从数据库中取出原对象
        User user = userService.getById(model.getId());

        // 2，设置要修改的属性
        //user.setLoginName(model.getLoginName());
        user.setMd5Password(DigestUtils.md5Hex("123456"));

        // 3，更新到数据库
        userService.update(user);

        return "toList";
    }

    /**
     * 登录页面
     */
    public String loginUI() throws Exception {
        return "loginUI";
    }

    /**
     * 登录
     */
    public String login() throws Exception {
        User user = userService.findByLoginNameAndPassword(
                model.getLoginName(), model.getMd5Password());
        if (user == null) {
            addFieldError("login", "用户名或密码不正确！");
            return "loginUI";
        } else {
            // 登录用户
            ActionContext.getContext().getSession().put("user", user);
            return "index";
        }
    }

    /**
     * 主页
     */
    public String index() throws Exception {
        return "index";
    }

    /**
     * 注销
     */
    public String logout() throws Exception {
        ActionContext.getContext().getSession().remove("user");
        return "loginUI";
    }

    /**
     * 注册页面
     */
    public String registerUI() throws Exception {
        return "registerUI";
    }

    /**
     * 注册
     */
    public String register() throws Exception {
        if (!model.getMd5Password().equals(model.getRePassword()))
            addFieldError("login", "两次密码输入不一致");
        User user = userService.findByLoginName(model.getLoginName());
        if (user != null) {
            addFieldError("register", "此用户名已被占用");
            return "registerUI";
        } else {
            // >> 设置密码（要使用MD5摘要）
            String md5Digest = DigestUtils.md5Hex(model.getMd5Password());
            model.setMd5Password(md5Digest);
            // 保存到数据库
            userService.save(model);
            addFieldError("register", "注册成功");
            return "loginUI";
        }
    }

}
