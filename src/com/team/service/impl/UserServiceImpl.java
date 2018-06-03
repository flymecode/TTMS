package com.team.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.team.dao.UserDao;
import com.team.domain.User;
import com.team.service.UserService;
import com.team.utils.BeanFactory;

/**
 * 用户业务逻辑实现
 * 
 * @author maxu
 *
 */
public class UserServiceImpl implements UserService {
	UserDao ud = (UserDao) BeanFactory.createObject("UserDaoImpl");

	@Override
	public void userRegist(User user) throws SQLException {
		ud.userRegist(user);
	}

	@Override
	public User userLogin(User user) throws SQLException {
		User uu = ud.userLogin(user);
		if (null == uu) {
			throw new RuntimeException("密码或账号错误");
		} else if (uu.getState() == 0) {
			throw new RuntimeException("用户未激活");
		} else {
			return uu;
		}
	}

	@Override
	public boolean userActive(String code) throws SQLException {
		User user = ud.userActive(code);

		if (null != user) {
			
			user.setCode(null);
			user.setState(1);
			//更新用户信息
			ud.update(user);
			
			return true;
		}
		return false;
	}

	@Override
	public boolean checkUserName(String userName) throws SQLException {
		return	ud.checkUserName(userName);
	}

	@Override
	public List<User> findUserWithPage() throws SQLException {
		return ud.findUserWithPage();
	}

	@Override
	public void deleteUser(String uid) throws SQLException {
		ud.deleteUser(uid);
	}

}
