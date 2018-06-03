package com.team.service;

import java.sql.SQLException;
import java.util.List;

import com.team.domain.Order;
import com.team.domain.OrderItem;

public interface OrderService {
	/**
	 * 提交购物项
	 * @param orderItem
	 * @throws SQLException
	 */
	void submitOrderItem(OrderItem orderItem)throws SQLException;

	/**
	 * 提交订单
	 * @param order
	 * @throws SQLException
	 */
	void submitOrder(Order order)throws SQLException;

	/**
	 * 查找订单根据订单id
	 * @param oid
	 * @return 订单对象
	 * @throws SQLException
	 */
	Order findOrderByOid(String oid)throws SQLException;

	/**
	 * 更新订单
	 * @param order
	 * 
	 * @throws SQLException
	 */
	void updateOrder(Order order) throws SQLException;

	/**
	 * 查找订单根据用户的id
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	List<Order> findOrderByUid(String uid)throws SQLException;

	/**
	 * 查找订单条目根据订单的id
	 * @param oid 订单的id
	 * @return 订单条目的集合
	 * @throws SQLException
	 */
	List<OrderItem> findOrderItemByOid(String oid)throws SQLException;

	/**
	 * 删除订单
	 * @param oid
	 * @throws SQLException
	 */
	void deleteOrder(String oid)throws SQLException;
	/**
	 * 发现全部的订单
	 * @return
	 * @throws SQLException
	 */
	List<Order> findAllOrder()throws SQLException;
	
}
