package com.team.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.team.dao.HallDao;
import com.team.domain.Hall;
import com.team.utils.JDBCUtils;

public class HallDaoImpl implements HallDao {

	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	@Override
	public Hall findHallByHid(String hid) throws SQLException {
		String sql = "select * from hall where hid = ?";
		return qr.query(sql, new BeanHandler<Hall>(Hall.class), hid);
	}

	@Override
	public List<Hall> findAllHall() throws SQLException {
		String sql = "select * from hall";
		return qr.query(sql, new BeanListHandler<Hall>(Hall.class));
	}

	@Override
	public void addHall(Hall hall) throws SQLException {
		String sql = "insert into hall(hid,hname,hdescription) values(?,?,?)";
		 Object[] params = { hall.getHid(), hall.getHname(), hall.getHdescription() };
		qr.update(sql,params);

	}

	@Override
	public void deleteHall(String id) throws SQLException {
		String sql = "delete from hall where hid=?";
		qr.update(sql, id);

	}

	@Override
	public void updataHall(Hall hall) throws SQLException {
		String sql = "update hall set hname=? ,hdescription=? where hid=?";
		Object[] params = {hall.getHname(),hall.getHdescription(),hall.getHid()};
		qr.update(sql,params);
	}

}
