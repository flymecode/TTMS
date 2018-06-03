package com.team.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.team.dao.OrderDao;
import com.team.domain.Order;
import com.team.domain.OrderItem;
import com.team.utils.JDBCUtils;

public class OrderDaoImpl implements OrderDao {
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	@Override
	public void submitOrderItem(OrderItem orderItem) throws SQLException {
		String sql = "insert into orderitem values(?,?,?,?,?,?,?)";
		Object[] params = { orderItem.getOiid(), orderItem.getMovie().getMid(), orderItem.getOid(), orderItem.getNum(),
				orderItem.getSubTotal(), orderItem.getHall().getHname(), orderItem.getTime() };
		qr.update(sql, params);
	}

	@Override
	public void submitOrder(Order order) throws SQLException {
		String sql = "insert into ordercart values (?,?,?,?,?) ";
		Object[] params = { order.getOid(), order.getUid(),order.getTotal(),order.getOrderTime(),order.getState()};
		qr.update(sql, params);
	}

	@Override
	public Order findOrderByOid(String oid) throws SQLException {
		String sql = "select * from ordercart where oid = ?";
		return qr.query(sql, new BeanHandler<Order>(Order.class)) ;
	}

	@Override
	public void updateOrder(Order order) throws SQLException {
		String sql = "update ordercart set state = ?";
		Object[] params = {order.getState()};
		qr.update(sql, params);
	}

	@Override
	public List<Order> findOrderByUid(String uid) throws SQLException {
		String sql = "select * from ordercart where uid = ?";
		return qr.query(sql, new BeanListHandler<Order>(Order.class),uid);
	}

	@Override
	public List<OrderItem> findOrderItemByOid(String oid) throws SQLException {
		String sql = "select * from orderitem where oid = ?";
		return  qr.query(sql, new BeanListHandler<OrderItem>(OrderItem.class),oid);
	}

	@Override
	public void deleteOrder(String oid) throws SQLException {
		String sql = "delete from ordercart where oid = ?";
		qr.update(sql,oid);
	}

	@Override
	public List<Order> findAllOrder() throws SQLException {
		String sql = "select * from ordercart";
		return qr.query(sql, new BeanListHandler<Order>(Order.class));
	}

}
