package com.team.dao;

import java.sql.SQLException;
import java.util.List;

import com.team.domain.Seat;

public interface SeatDao {

	/**
	 * 保存座位的信息
	 * @param list
	 * @throws SQLException
	 */
	void saveSeat(List<Seat> list) throws SQLException;

	/**
	 * 判断座位是否被选中
	 * @param hid
	 * @return
	 * @throws SQLException
	 */
	List<Seat> isSelect(String hid) throws SQLException;

	/**
	 * 删除座位的信息
	 * @param oid
	 * @throws SQLException
	 */
	void deleteSeatByOid(String oid)throws SQLException;

}
