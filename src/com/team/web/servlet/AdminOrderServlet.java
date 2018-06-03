package com.team.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.domain.Order;
import com.team.service.OrderService;
import com.team.service.impl.OrderServiceImpl;
import com.team.web.base.BaseServlet;

/**
 * 管理订单模块
 */
public class AdminOrderServlet extends BaseServlet {

	// 发现所有的订单
	public String findAllOrder(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		 
		OrderService service  = new OrderServiceImpl();
		List<Order> list = service.findAllOrder();
		request.setAttribute("list", list);
		return "admin/main/allorder.jsp";
	}
	
	//删除用户订单
	
	public String deleteOrder(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		
		String oid = request.getParameter("oid");
		OrderService service  = new OrderServiceImpl();
		service.deleteOrder(oid);
		
		return null;
	}

}
