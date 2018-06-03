package com.team.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.domain.Admin;
import com.team.domain.Hall;
import com.team.service.AdminService;
import com.team.service.HallService;
import com.team.service.impl.AdminServiceImpl;
import com.team.service.impl.HallServiceImpl;
import com.team.utils.MyBeanUtils;
import com.team.utils.UUIDUtils;
import com.team.web.base.BaseServlet;

/**
 * 管理者模块
 */
public class AdminServlet extends BaseServlet {
	// 默认方法
	public String adminLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		Map map = request.getParameterMap();
		Admin admin = new Admin();
		MyBeanUtils.populate(admin, map);

		AdminService service = new AdminServiceImpl();
		admin = service.adminLogin(admin);
		if (null != admin) {
			request.getSession().setAttribute("admin", admin);
			return "admin/main/home.jsp";
		}
		return null;
	}

	// 管理员注销
	public String logOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		request.getSession().removeAttribute("admin");
		return "admin/index.jsp";
	}

	// 查看所有演出厅
	public String findAllHall(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		HallService service = new HallServiceImpl();
		List<Hall> list = service.findAllHall();
		request.getSession().setAttribute("halllist", list);
		return "/admin/main/hall.jsp";

	}

	// 增加演出厅
	public String AddHall(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		HallService service = new HallServiceImpl();
		Map<String, String[]> map = request.getParameterMap();
		Hall hall = new Hall();
		hall.setHid(UUIDUtils.getId());
		MyBeanUtils.populate(hall, map);
		service.addHall(hall);
		return null;

	}

	// 删除演出厅
	public String deleteHall(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String hid = request.getParameter("hid");
		HallService service = new HallServiceImpl();
		service.deleteHall(hid);
		return null;

	}
	
	//更新演出厅转发
	public String updataHallUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String hid = request.getParameter("hid");
		HallService service = new HallServiceImpl();
		Hall hall = service.findHallByHid(hid);
		request.setAttribute("hall", hall);
		return "admin/main/updataHall.jsp";
	}
		
	//更新演出厅
	public String updataHall(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		HallService service = new HallServiceImpl();
		Map<String, String[]> map = request.getParameterMap();
		Hall hall= new Hall();
		MyBeanUtils.populate(hall, map);
		service.updataHall(hall);
		return null;
		
	}

}
