package com.meeks.util;


import com.meeks.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckPrivilegeInterceptor extends AbstractInterceptor {

	public String intercept(ActionInvocation invocation) throws Exception {
		// 获取信息
		User user = (User) ActionContext.getContext().getSession().get("user"); // 当前登录用户
		String namespace = invocation.getProxy().getNamespace();
		String actionName = invocation.getProxy().getActionName();
		String privUrl = namespace + actionName; // 对应的权限URL

		// 如果未登录
		if (user == null) {
			if (privUrl.startsWith("/user_login")) {
				// 如果是去登录，就放行
				return invocation.invoke();
			}else if(privUrl.startsWith("/user_register")){
				// 如果是去注册，就放行
				return invocation.invoke();
			}else {
				// 如果不是去登录，就转到登录页面
				return "loginUI";
			}
		}
		return invocation.invoke();
	}

}
