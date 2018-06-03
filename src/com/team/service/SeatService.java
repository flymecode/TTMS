package com.team.service;

import java.sql.SQLException;
import java.util.List;

import com.team.domain.Seat;

public interface SeatService {

	/**
	 * 保存座位信息
	 * @param list
	 * @throws SQLException
	 */
	void saveSeat(List<Seat> list) throws SQLException;

	/**
	 * 判断座位是否选中
	 * @param hid 演出厅id
	 * @return
	 * @throws SQLException
	 */
	List<Seat> isSelect(String hid) throws SQLException;

}
