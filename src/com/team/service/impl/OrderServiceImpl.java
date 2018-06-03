package com.team.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.team.dao.MovieDao;
import com.team.dao.OrderDao;
import com.team.dao.SeatDao;
import com.team.dao.impl.MovieDaoImpl;
import com.team.dao.impl.OrderDaoImpl;
import com.team.dao.impl.SeatDaoImpl;
import com.team.domain.Order;
import com.team.domain.OrderItem;
import com.team.service.OrderService;

public class OrderServiceImpl implements OrderService {

	OrderDao od = new OrderDaoImpl();
	MovieDao md = new MovieDaoImpl();
	SeatDao sd = new SeatDaoImpl();

	@Override
	public void submitOrderItem(OrderItem orderItem) throws SQLException {
		od.submitOrderItem(orderItem);
	}

	@Override
	public void submitOrder(Order order) throws SQLException {
		od.submitOrder(order);
	}

	@Override
	public Order findOrderByOid(String oid) throws SQLException {
		return od.findOrderByOid(oid);
	}

	@Override
	public void updateOrder(Order order) throws SQLException {
		od.updateOrder(order);

	}

	@Override
	public List<Order> findOrderByUid(String uid) throws SQLException {
		// 根据用户的id查询订单
		return od.findOrderByUid(uid);

	}

	@Override
		public List<OrderItem> findOrderItemByOid(String oid) throws SQLException {
		List<OrderItem> list = od.findOrderItemByOid(oid);
		for (OrderItem orderitem : list) {
			orderitem.setMovie(md.findMovieById(orderitem.getMid()));
		}

		return list;
	}

	@Override
	public void deleteOrder(String oid) throws SQLException {
		od.deleteOrder(oid);
		// 删除订单下的座位信息
		sd.deleteSeatByOid(oid);
	}

	@Override
	public List<Order> findAllOrder() throws SQLException {
		List<Order> list = od.findAllOrder();
		for (Order order : list) {
			List<OrderItem> orderItem = od.findOrderItemByOid(order.getOid());
			order.setOrderItem(orderItem);
		}
		return list;
	}

}
