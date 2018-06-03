package com.team.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.domain.Movie;
import com.team.service.MovieService;
import com.team.service.impl.MovieServiceImpl;
import com.team.web.base.BaseServlet;

/**
 * 正在上映, 即将上映
 */
public class IndexServlet extends BaseServlet {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		MovieService service = new MovieServiceImpl();
		List<Movie> coming = service.findComingSoon();
		List<Movie> playing = service.findNowPlaying();
		
		request.setAttribute("com", coming);
		request.setAttribute("play", playing);
		
		return "/jsp/index.jsp";
	}

}
