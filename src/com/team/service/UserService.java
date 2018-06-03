package com.team.service;

import java.sql.SQLException;
import java.util.List;

import com.team.domain.User;

/**
 * 用户业务处理
 * 
 * @author maxu
 *
 */

public interface UserService {
	/**
	 * 用户注册
	 * 
	 * @param user
	 *            用户对象
	 * @throws SQLException
	 */
	void userRegist(User user) throws SQLException;

	/**
	 * 用户登陆
	 * 
	 * @param user
	 *            用户对象
	 * @return 用户对象
	 * @throws SQLException
	 */
	User userLogin(User user) throws SQLException;

	/**
	 * 用户激活
	 * 
	 * @param code
	 *            激活码
	 * @return true 激活成功 false 激活失败
	 * @throws SQLException
	 */
	boolean userActive(String code) throws SQLException;
	/**
	 * 用户名校验
	 * @param userName 用户名
	 * @return true 用户名可用 false 用户名不可用
	 * @throws SQLException
	 */
	boolean checkUserName(String userName) throws SQLException;
	/**
	 * 查询所有用户的信息
	 * @return
	 * @throws SQLException
	 */
	List<User> findUserWithPage()throws SQLException;
	/**
	 * 根据用户的id删除用户 
	 * @param uid 用户的id
	 * @throws SQLException
	 */
	void deleteUser(String uid)throws SQLException;

}
