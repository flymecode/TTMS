package com.team.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.team.dao.AdminDao;
import com.team.domain.Admin;
import com.team.utils.JDBCUtils;

public class AdminDaoImpl implements AdminDao {
	
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	
	@Override
	public Admin adminLogin(Admin admin) throws SQLException {
		String sql = "select * from admin where username = ? and password = ?";
		return qr.query(sql,new BeanHandler<Admin>(Admin.class),admin.getUsername(),admin.getPassword());
	}
}

