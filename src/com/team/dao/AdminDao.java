package com.team.dao;

import java.sql.SQLException;

import com.team.domain.Admin;

public interface AdminDao {
	/**
	 * 管理员登陆
	 * @param admin
	 * @return
	 * @throws SQLException
	 */
	Admin adminLogin(Admin admin) throws SQLException;

}
