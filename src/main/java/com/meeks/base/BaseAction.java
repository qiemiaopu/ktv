package com.meeks.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.meeks.domain.User;
import com.meeks.service.BillService;
import com.meeks.service.CardVIPService;
import com.meeks.service.HouseService;
import com.meeks.service.ReserveService;
import com.meeks.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction<T> extends ActionSupport implements
		ModelDriven<T> {

	// =============== ModelDriven的支持 ==================

	protected T model;

	public BaseAction() {
		try {
			// 通过反射获取model的真实类型
			ParameterizedType pt = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			// 通过反射创建model的实例
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {
		return model;
	}

	// =============== Service实例的声明 ==================
	@Resource
	protected CardVIPService cardVIPService;
	@Resource
	protected HouseService houseService;
	@Resource
	protected ReserveService reserveService;
	@Resource
	protected BillService billService;
	@Resource
	protected UserService userService;
	//@Resource
	//protected ThouseService thouseService;
	//@Resource
	//protected PrivilegeService privilegeService;

	/**
	 * 获取当前登录的用户
	 *
	 * @return
	 */
	protected User getCurrentUser() {
		return (User) ActionContext.getContext().getSession().get("user");
	}
	/**
	 * 判断本用户是否是超级管理员
	 *
	 * @return
	 */
	public boolean isAdmin() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		return ("admin".equals(user.getLoginName()));
	}


	// ============== 分页用的参数 =============

	protected int pageNum = 1; // 当前页
	protected int pageSize = 7; // 每页显示多少条记录

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
