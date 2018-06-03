package com.team.dao;

import java.sql.SQLException;
import java.util.List;

import com.team.domain.Schedule;
/**
 * 演出计划Dao
 * @author maxu
 *
 */
public interface ScheduleDao {
	/**
	 * 根据电影id查询演出详情
	 * @param mid 电影id
	 * @return 返回电影播出详情
	 * @throws SQLException
	 */
	List<Schedule> findPlayInfo(String mid) throws SQLException;
	
	/**
	 * 根据演出id查询演出计划的详细信息
	 * @param sid 演出计划id
	 * @return 返回演出计划对象
	 * @throws SQLException
	 */
	Schedule findPlayInfoById(String sid)throws SQLException;

	/**
	 * 查找全部的演出计划
	 * @return
	 * @throws SQLException
	 */
	List<Schedule> findAllSchedule()throws SQLException;

	/**
	 * 增加演出计划
	 * @param schedule 演出计划对象
	 * @throws SQLException
	 */
	void addSchedule(Schedule schedule)throws SQLException;

	
}
