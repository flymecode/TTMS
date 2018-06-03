package com.team.service;

import java.sql.SQLException;
import java.util.List;

import com.team.domain.Hall;
/**
 * 演出厅处理的业务
 * @author maxu
 *
 */
public interface HallService {
	/**
	 * 根据演出厅的id查询演出计划
	 * @param hid 演出厅id
	 * @return 返回演出厅对象
	 * @throws SQLException
	 */
	public Hall findHallByHid(String hid) throws SQLException;
	/**
	 * 查找所有的演出厅
	 * @return
	 */
	public List<Hall> findAllHall()throws SQLException;
	/**
	 * 增加演出厅
	 * @param hall
	 */
	public void addHall(Hall hall) throws SQLException;
	/**
	 * 删除演出厅
	 * @param hid
	 * @throws SQLException
	 */
	public void deleteHall(String hid)throws SQLException;
	/**
	 * 更新演出厅
	 * @param hall
	 * @throws SQLException
	 */
	public void updataHall(Hall hall)throws SQLException;
}
