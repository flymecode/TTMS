package com.team.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.domain.Category;
import com.team.service.CategoryService;
import com.team.service.impl.CategoryServiceImpl;
import com.team.utils.JedisUtils;
import com.team.web.base.BaseServlet;

import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

/**
 * 分类模块
 */
public class CategoryServlet extends BaseServlet {

	public String findAllMovieCats(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
	
		// 在Redis获取全部信息
		Jedis jedis = JedisUtils.getJedis();
		String jsonStr = jedis.get("allCats");
		if (null == jsonStr || "".equals(jsonStr)) {
			CategoryService service = new CategoryServiceImpl();
			// 发现所有的电影的分类
			List<Category> list = service.findAllMovieCats();
			// 转化为Json串发送给前端
			jsonStr = JSONArray.fromObject(list).toString();
			jedis.set("allCats", jsonStr);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().print(jsonStr);
		} else {
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().print(jsonStr);
		}
		JedisUtils.closeJedis(jedis);
		return null;

	}

}
