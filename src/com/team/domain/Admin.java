package com.team.domain;
/**
 * 管理员模型
 * @author maxu
 *
 */
public class Admin {
	
	private String aid;//管理员的id
	private String name;//管理员的
	private String username;//管理员用户
	private String password;//管理员密码
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
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

	
}
