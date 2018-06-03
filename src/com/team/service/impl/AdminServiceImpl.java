package com.team.service.impl;

import java.sql.SQLException;

import com.team.dao.AdminDao;
import com.team.dao.impl.AdminDaoImpl;
import com.team.domain.Admin;
import com.team.service.AdminService;

public class AdminServiceImpl implements AdminService {
	
	AdminDao ad = new AdminDaoImpl();
	@Override
	public Admin adminLogin(Admin admin) throws SQLException {
		return ad.adminLogin(admin);
	}

}
