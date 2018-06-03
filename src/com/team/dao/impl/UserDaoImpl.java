package com.team.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.team.dao.UserDao;
import com.team.domain.User;
import com.team.utils.JDBCUtils;

/**
 * 用户模块开发
 * 
 * @author maxu
 *
 */
public class UserDaoImpl implements UserDao {
	// 数据库连接池
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	@Override
	public void userRegist(User user) throws SQLException {
		String sql = "insert into user values(?,?,?,?,?,?,?,?)";
		Object[] params = { user.getUid(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(),
				user.getBirthday(), user.getCode(), user.getState() };
		qr.update(sql, params);
	}

	@Override
	public User userLogin(User user) throws SQLException {
		String sql = "select * from user where username =? and password=?";
		return qr.query(sql, new BeanHandler<User>(User.class), user.getUsername(), user.getPassword());
	}

	@Override
	public User userActive(String code) throws SQLException {
		String sql = "select * from user where code=?";
		return qr.query(sql, new BeanHandler<User>(User.class), code);
	}

	@Override
	public boolean checkUserName(String userName) throws SQLException {
		String sql = "select count(username) from user where username=?";
		Long count = (Long) qr.query(sql, new ScalarHandler(), userName);
		return count == 0;
	}

	@Override
	public void update(User user) throws SQLException {
		String sql = "update user set username=?,password=?,name=?,email=?,birthday=?,code=?,state=?";
		Object[] params = { user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getBirthday(),
				user.getCode(), user.getState() };
		qr.update(sql, params);
	}

	// 这是一个用来更新修改User数据的方法
	public void update(User user, String uid) throws SQLException {
		String sql = "update user set username=?,password=?,name=?,email=?,birthday=?,code=?,state=? where uid=?";
		Object[] params = { user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getBirthday(),
				user.getCode(), user.getState(), user.getUid() };
		qr.update(sql, params);
	}

	@Override
	public List<User> findUserWithPage() throws SQLException {
		String sql = "select * from user";
		return qr.query(sql, new BeanListHandler<User>(User.class));
	}

	@Override
	public void deleteUser(String uid) throws SQLException {
		String sql = "delete from user where uid =?";
		qr.update(sql, uid);
	}

}
