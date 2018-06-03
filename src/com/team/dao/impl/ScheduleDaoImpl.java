package com.team.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.team.dao.ScheduleDao;
import com.team.domain.Schedule;
import com.team.utils.JDBCUtils;

public class ScheduleDaoImpl implements ScheduleDao {

	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	@Override
	public List<Schedule> findPlayInfo(String mid) throws SQLException {
		String sql = "select * from schedule where mid =?";
		return qr.query(sql, new BeanListHandler<Schedule>(Schedule.class), mid);
	}

	@Override
	public Schedule findPlayInfoById(String sid) throws SQLException {
		String sql = "select * from schedule where sid =?";
		return qr.query(sql, new BeanHandler<Schedule>(Schedule.class), sid);
	}

	@Override
	public List<Schedule> findAllSchedule() throws SQLException {
		String sql ="select * from schedule";
		return qr.query(sql, new BeanListHandler<Schedule>(Schedule.class));
	}

	@Override
	public void addSchedule(Schedule schedule) throws SQLException {
		String sql ="insert into schedule values (?,?,?,?)";
		Object[] params = {schedule.getSid(),schedule.getMid(),schedule.getHid(),schedule.getTime()};
		qr.update(sql,params);
	}

}
