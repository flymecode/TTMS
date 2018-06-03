package com.team.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.team.dao.HallDao;
import com.team.dao.impl.HallDaoImpl;
import com.team.domain.Hall;
import com.team.service.HallService;

public class HallServiceImpl implements HallService {

	HallDao hd = new HallDaoImpl();

	@Override
	public Hall findHallByHid(String hid) throws SQLException {
		return hd.findHallByHid(hid);
	}

	@Override
	public List<Hall> findAllHall() throws SQLException {
		return hd.findAllHall();
	}

	@Override
	public void addHall(Hall hall) throws SQLException {
		hd.addHall(hall);

	}

	public void deleteHall(String id) throws SQLException {
		hd.deleteHall(id);
	}

	public void updataHall(Hall hall) throws SQLException {
		hd.updataHall(hall);
	}

}
