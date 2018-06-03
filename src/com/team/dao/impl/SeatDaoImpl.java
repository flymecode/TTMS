package com.team.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.team.dao.SeatDao;
import com.team.domain.Seat;
import com.team.utils.JDBCUtils;

public class SeatDaoImpl implements SeatDao {

	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	@Override
	public void saveSeat(List<Seat> list) throws SQLException {
		String sql = "insert into seat values(?,?,?,?,?,?)";
		for (Seat seat : list) {
			Object[] params = { seat.getSeid(), seat.getRow(), seat.getColumn(), seat.getState(), seat.getHid(),seat.getOid()};
			qr.update(sql, params);
		}
	}

	@Override
	public List<Seat> isSelect(String hid) throws SQLException {
		String sql = "select * from seat where hid = ?";
		return qr.query(sql, new BeanListHandler<Seat>(Seat.class),hid);
	}

	@Override
	public void deleteSeatByOid(String oid) throws SQLException {
		String sql = "delete from seat where oid = ?";
		qr.update(sql,oid);
	}

}
