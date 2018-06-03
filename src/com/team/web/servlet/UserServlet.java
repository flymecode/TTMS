package com.team.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.dao.impl.UserDaoImpl;
import com.team.domain.User;
import com.team.service.UserService;
import com.team.service.impl.UserServiceImpl;
import com.team.utils.MailUtils;
import com.team.utils.MyBeanUtils;
import com.team.utils.UUIDUtils;
import com.team.web.base.BaseServlet;

/**
 * 用户模块
 */
public class UserServlet extends BaseServlet {

	// 用户名校验
	public String checkUserName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		// 获取用户名
		String userName = request.getParameter("username");
		System.out.println(userName);
		UserService service = new UserServiceImpl();
		// 告诉浏览器返回的是json格式的字符串
		response.setContentType("application/json;charset=utf-8");
		boolean flag = service.checkUserName(userName);
		if (flag) {
			String data = "{\"data\":\"满足要求\"}";
			response.getWriter().write(data);
		} else {
			String data = "{\"data\":\"用户名存在\"}";
			response.getWriter().write(data);
		}
		return null;
	}

	// 用户登录UI
	public String userLoginUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		return "/jsp/login.jsp";
	}

	public String updateUserInfoUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/jsp/updataUser.jsp";
	}

	// 用户注册UI
	public String userRegistUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/jsp/regist.jsp";
	}

	// 用户注册
	public String userRegist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, String[]> map = request.getParameterMap();
		User user = new User();
		MyBeanUtils.populate(user, map);
		// 为用户的其他属性进行赋值
		user.setUid(UUIDUtils.getId());
		user.setState(0);
		user.setCode(UUIDUtils.getCode());
		// 调度业务注册功能
		UserService service = new UserServiceImpl();

		try {
			service.userRegist(user);
			// 注册成功向，用户邮发送信息，跳转到提示信息页面
			// 发送邮件
			MailUtils.sendMail(user.getEmail(), user.getCode());
			request.setAttribute("msg", "用户注册成功，请激活！" + "<a href='www.qq.com'></a>");
		} catch (Exception e) {
			// 注册失败，跳转到提示页面
			request.setAttribute("msg", "用户注册失败，请重新注册！");
		}
		return "/jsp/info.jsp";

	}

	// 用户激活
	public String active(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 获取激活码
		String code = request.getParameter("code");
		// 调用业务层激活功能
		UserService userService = new UserServiceImpl();
		boolean flag = userService.userActive(code);
		// 进行激活信息提示
		if (flag == true) {
			// 用户激活成功,向request放入提示信息,转发到登录页面
			request.setAttribute("msg", "用户激活成功,请登录!");
			return "/jsp/login.jsp";
		} else {
			// 用户激活失败,向request放入提示信息,转发到提示页面
			request.setAttribute("msg", "用户激活失败,请重新激活!");
			return "/jsp/info.jsp";
		}
	}

	// 用户登陆
	public String userLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		try {
			String autoLogin = request.getParameter("remember");
			User user = new User();
			MyBeanUtils.populate(user, request.getParameterMap());
			UserService service = new UserServiceImpl();
			User user_c = new User();
			user_c = service.userLogin(user);

			if (null != user_c) {

				if ("on".equals(autoLogin)) {
					// 发送Cookie给客户端
					Cookie cookie = new Cookie("remember", user_c.getUsername() + "#" + user_c.getPassword());
					cookie.setMaxAge(60 * 60 * 24);
					cookie.setPath(request.getContextPath());
					response.addCookie(cookie);
					// 用户登陆成功，将用户信息放入session
					request.getSession().setAttribute("userLogin", user_c);
					response.sendRedirect("/TTMS/index.jsp");
				} else {
					// 用户登陆成功，将用户信息放入session
					request.getSession().setAttribute("userLogin", user_c);
					response.sendRedirect("/TTMS/index.jsp");
				}

			}

		} catch (Exception e) {
			String msg = e.getMessage();
			// 放入失败的信息
			request.setAttribute("msg", msg);
			// 转发到登陆界面
			return "/jsp/login.jsp";
		}
		return null;

	}

	// 用户退出
	public String userOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 清除session
		request.getSession().invalidate();
		// 重新定向到首页
		response.sendRedirect("/TTMS/index.jsp");
		return null;
	}

	// 用户修改账户信息并且将用户信息放到
	public String updateUserInfo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String birthday = request.getParameter("birthday");
		Map map = request.getParameterMap();

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userLogin");

		MyBeanUtils.populate(user, map);
		session.setAttribute("userLogin", user);
		UserDaoImpl uid = new UserDaoImpl();
		uid.update(user, user.getUid());
		request.setAttribute("msg", "更新成功");
		return "/jsp/info.jsp";

	}
	//删除用户
	public String deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String uid = request.getParameter("uid");
		UserService service = new UserServiceImpl();
		service.deleteUser(uid);
		return "admin/main/user.jsp";
	}

}
