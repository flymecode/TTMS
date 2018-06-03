package com.team.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.domain.User;
import com.team.service.UserService;
import com.team.service.impl.UserServiceImpl;
import com.team.web.base.BaseServlet;

/**
 * 
 */
public class AdminUserServlet extends BaseServlet {
	
	public String findUserWithPage(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		UserService service = new UserServiceImpl();
		List<User> list = service.findUserWithPage();
		request.setAttribute("list", list);
		return "admin/main/user.jsp";
	}

}
