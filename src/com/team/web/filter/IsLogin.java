package com.team.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 权限过滤
 */
public class IsLogin implements Filter {

    public IsLogin() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*HttpServletRequest req = (HttpServletRequest) request;
		if(null == req.getSession().getAttribute("userLogin")) {
			request.setAttribute("msg", "请登陆之后,再访问");
			req.getRequestDispatcher("info.jsp").forward(req, response);
		}*/
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
