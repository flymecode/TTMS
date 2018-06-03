package com.team.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.domain.Movie;
import com.team.domain.PageModel;
import com.team.service.MovieService;
import com.team.service.impl.MovieServiceImpl;
import com.team.web.base.BaseServlet;

/**
 * 电影信息模块
 */
public class MovieServlet extends BaseServlet {

	public String findMovieById(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		// 获取电影id
		String mid = request.getParameter("mid");

		MovieService service = new MovieServiceImpl();
		// 查询到电影对象
		Movie movie = service.findMovieById(mid);
		if (null != movie) {
			// 放在request域对象中
			request.setAttribute("movie", movie);
			// 转发到电影详情的页面
			return "/jsp/movie_info.jsp";
		} else {
			request.setAttribute("msg", "未找到该电影信息");
			return "/jsp/info.jsp";
		}

	}

	public String findMovieByName(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		// 获取电影id
		String movieName = request.getParameter("search");
		if (movieName == null || "".equals(movieName.trim())) {
			request.setAttribute("msg", "未输入");
			return "/jsp/info.jsp";
		}
		System.out.println(movieName);
		MovieService service = new MovieServiceImpl();
		// 查询到电影对象
		Movie movie = service.findMovieByName(movieName);
		// 放在request域对象中
		if (null != movie) {
			request.setAttribute("movie", movie);
			// 转发到电影详情的页面
			return "/jsp/movie_info.jsp";
		} else {
			request.setAttribute("msg", "未找到该电影信息");
			return "/jsp/info.jsp";
		}

	}

	public String findListMovie(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		String cid = request.getParameter("cid");

		MovieService service = new MovieServiceImpl();
		List<Movie> list = service.findListMovie(cid);
		// 查询到电影对象
		Movie m = service.findMovieById(cid);
		request.setAttribute("curm", list);
		return "/jsp/list.jsp";

	}

	public String findListMovieWithPage(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		int num = Integer.parseInt(request.getParameter("num"));
		String cid = request.getParameter("cid");
		MovieService service = new MovieServiceImpl();
		PageModel page = service.findListMovieWithPage(cid, num);
		request.setAttribute("page", page);
		return "/jsp/list.jsp";

	}

}
