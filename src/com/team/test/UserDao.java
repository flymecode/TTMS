package com.team.test;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.mysql.fabric.xmlrpc.base.Data;
import com.team.dao.SeatDao;
import com.team.dao.impl.SeatDaoImpl;
import com.team.domain.Order;
import com.team.domain.OrderItem;
import com.team.domain.Seat;
import com.team.domain.User;
import com.team.service.OrderService;
import com.team.service.impl.OrderServiceImpl;
import com.team.utils.JDBCUtils;

public class UserDao {

	User user = new User();
	
	@Test
	public void userRegist() throws SQLException {
		user.setBirthday(new Date());
		user.setCode("DFF44FF8D7FF4D449DC5D4EE9EA382C5");
		user.setEmail("1272193308@qq.com");
		user.setName("马旭");
		user.setPassword("123");
		user.setUid("DFF44FF8D7FF4D449DC5D4EE9EA382e5");
		user.setState(0);
		user.setUsername("admin");
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?)";
		Object[] params = { user.getUid(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(),
				user.getBirthday(), user.getCode(), user.getState() };
		//qr.update(sql, params);
	}
	
	OrderItem orderItem = new OrderItem();
	
	@Test
	public void submitOrder() throws SQLException {
	
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

		String sql ="insert into orderitem values (?, ?, ?,?,?,?,?)";
		Object[] params = {"1516B42218304548B1FDADF6E4B84754","1","659E34B244F744DBAEECF7DCBBEFEB31",3,60.0,"一号厅","2018-05-02T03:03"};
		qr.update(sql, params);
	}
	
	@Test
	public void submitOrder1() throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql ="insert into ordercart values (?,?,?,?) ";
		Object[] params = {};
		qr.update(sql, "2","05BCD8EA30984236A97056C925D227F7",55,null);
	}
	@Test
	public void submit() throws SQLException {
		
		SeatDao dao = new SeatDaoImpl();
		List<Seat> seat = dao.isSelect("1");
		for (Seat s : seat) {
			System.out.println(s.getRow()+""+s.getColumn());
			
		}
	}
	
	
	@Test
	public void test() throws SQLException {
		
		OrderService service = new OrderServiceImpl();
		List<Order> list = service.findOrderByUid("05BCD8EA30984236A97056C925D227F7");
	
		for (Order orderItem : list) {
			
			System.out.println(orderItem.getOid());
			System.out.println(orderItem.getState());
			System.out.println(orderItem.getTotal());
			System.out.println(orderItem.getOrderTime());
			System.out.println(orderItem.getOrderItem().get(0).getTime());
			System.out.println(orderItem.getOrderItem().get(0).getHname());
		}
	}
	

	
	

}
