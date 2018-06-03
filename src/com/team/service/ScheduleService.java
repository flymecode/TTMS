package com.team.service;

import java.sql.SQLException;
import java.util.List;

import com.team.domain.OrderItem;
import com.team.domain.Schedule;

/**
 * 时间安排表的业务逻辑
 * @author maxu
 *
 */
public interface ScheduleService {
	/**
	 * 根据电影id查询计划表的安排信息
	 * @param mid 电影id
	 * @return 计划表的集合
	 * @throws SQLException
	 */
	List<Schedule> findPlayInfo(String mid) throws SQLException;
	/**
	 * 根据计划表的id查询播放信息
	 * @param sid
	 * @return
	 * @throws SQLException
	 */
	Schedule findPlayInfoById(String sid)throws SQLException;
	/**
	 * 根据计划表的id查询计划表的信息,从而找到其他表的信息
	 * @param sid 计划表的id
	 * @return 返回一个订单条目对象
	 * @throws SQLException
	 */
	OrderItem findOrderInfo(String sid)throws SQLException;
	/**
	 * 查找所有的演出计划
	 * @return 演出计划的集合
	 * @throws SQLException
	 */
	List<Schedule> findAllSchedule()throws SQLException;
	/**
	 * 增加演出计划
	 * @param schedule
	 * @throws SQLException
	 */
	void addSchedule(Schedule schedule)throws SQLException;
}
