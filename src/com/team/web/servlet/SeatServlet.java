package com.team.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.team.domain.Seat;
import com.team.service.SeatService;
import com.team.service.impl.SeatServiceImpl;
import com.team.utils.JedisUtils;
import com.team.web.base.BaseServlet;

import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

/**
 * 座位是否被选择
 */
public class SeatServlet extends BaseServlet {

	//查看座位是否被选择
	public String isSelect(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String hid = request.getParameter("hid");
		SeatService service = new SeatServiceImpl();
		List<Seat> list = service.isSelect(hid);
		String str = JSONArray.fromObject(list).toString();
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(str);
		return null;
	}
}
