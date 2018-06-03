package com.team.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.domain.Hall;
import com.team.domain.Movie;
import com.team.domain.Schedule;
import com.team.service.HallService;
import com.team.service.MovieService;
import com.team.service.ScheduleService;
import com.team.service.impl.HallServiceImpl;
import com.team.service.impl.MovieServiceImpl;
import com.team.service.impl.ScheduleServiceImpl;
import com.team.utils.MyBeanUtils;
import com.team.utils.UUIDUtils;
import com.team.web.base.BaseServlet;

import net.sf.json.JSONArray;

/**
 * 演出计划表
 */
public class ScheduleServlet extends BaseServlet {
	//查看演出计划的详细信息
	public String findPlayInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String mid = request.getParameter("mid");
		ScheduleService service = new ScheduleServiceImpl();
		List<Schedule> list = service.findPlayInfo(mid);
		request.setAttribute("list", list);
		response.setContentType("application/json;charset=utf-8");
		String str = JSONArray.fromObject(list).toString();
		response.getWriter().println(str);
		return null;
	}
	//查找全部的演出计划
	public String findAllSchedule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		ScheduleService service = new ScheduleServiceImpl();
		List<Schedule> list = service.findAllSchedule();
		request.setAttribute("list", list);
		return "admin/main/schedule.jsp";
	}
	
	public String addScheduleUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//查询到所有的电影
		MovieService service = new MovieServiceImpl();
		List<Movie> list = service.findAllMovie();
		HallService hservice = new HallServiceImpl();
		List<Hall> hlist = hservice.findAllHall();
		request.setAttribute("list", list);
		request.setAttribute("hlist", hlist);
		return "admin/main/addSchedule.jsp";
	}
	//增加演出计划
	public String addSchedule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		ScheduleService service = new ScheduleServiceImpl();
		Map map = request.getParameterMap();
		Schedule schedule = new Schedule();
		schedule.setSid(UUIDUtils.getId());
		MyBeanUtils.populate(schedule, map);
		service.addSchedule(schedule);
		return null;
		
	}
	
	
}
