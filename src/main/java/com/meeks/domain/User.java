package com.meeks.domain;

/**
 * 账户,员工
 */
public class User {
	private Integer id;
	private String loginName;
	private String md5Password;
	private String rePassword;

	private String name;
	private Long phone;
	private String position;

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getMd5Password() {
		return md5Password;
	}

	public void setMd5Password(String md5Password) {
		this.md5Password = md5Password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
