package com.team.domain;

import java.util.Date;

public class User {

	private String username; // 用户名
	private String password; // 密码
	private String name; // 姓名
	private String email; // 邮箱
	private Date birthday; // 生日
	private String code; // 激活码
	private int state; // 状态
	private String uid; // 用户id

	public User() {
		super();
	}

	public User(String username, String password, String name, String email, Date birthday, String code, int state,
			String uid) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.birthday = birthday;
		this.code = code;
		this.state = state;
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}
