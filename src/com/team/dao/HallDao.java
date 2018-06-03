package com.team.dao;

import java.sql.SQLException;
import java.util.List;

import com.team.domain.Hall;

/**
 * 电影厅表
 * 
 * @author maxu
 *
 */
public interface HallDao {
	/**
	 * 根据演出厅id查询演出厅的详细信息
	 * @param hid 演出id
	 * @return 演出厅的对象
	 * @throws SQLException
	 */
	Hall findHallByHid(String hid) throws SQLException;
	/**
	 * 查找所有的演出厅
	 * @return
	 * @throws SQLException
	 */
	List<Hall> findAllHall()throws SQLException;
	/**
	 * 增加演出厅
	 * @param hall
	 * @throws SQLException
	 */
	void addHall(Hall hall)throws SQLException;
	/**
	 * 删除演出厅
	 * @param id
	 * @throws SQLException
	 */
	void deleteHall(String id)throws SQLException;
	/**
	 * 更新演出厅
	 * @param hall
	 * @throws SQLException
	 */
	void updataHall(Hall hall)throws SQLException;
}
