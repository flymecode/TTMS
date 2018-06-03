package com.team.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.team.dao.SeatDao;
import com.team.dao.impl.SeatDaoImpl;
import com.team.domain.Seat;
import com.team.service.SeatService;

public class SeatServiceImpl implements SeatService {

	SeatDao sd = new SeatDaoImpl();
	@Override
	public void saveSeat(List<Seat> list) throws SQLException {
		
		sd.saveSeat(list);
	}
	@Override
	public List<Seat> isSelect(String hid) throws SQLException {
		return sd.isSelect(hid);
	}

}
