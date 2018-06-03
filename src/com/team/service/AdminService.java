package com.team.service;

import java.sql.SQLException;

import com.team.domain.Admin;

public interface AdminService {
	/**
	 * 管理员登陆
	 * @param admin 管理员对象
	 * @return 返回管理员对象
	 * @throws SQLException
	 */
	Admin adminLogin(Admin admin) throws SQLException;

}
