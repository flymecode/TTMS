package com.team.dao;

import java.sql.SQLException;
import java.util.List;

import com.team.domain.User;

/**
 * 这是操作用户表的dao
 * 
 * @author maxu
 *
 */
public interface UserDao {
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
	 * @return 返回一个用户对象
	 * @throws SQLException
	 */
	User userLogin(User user) throws SQLException;

	/**
	 * 用户激活
	 * 
	 * @param code
	 *            激活码
	 * @return 返回一个用户对象
	 * @throws SQLException
	 */
	User userActive(String code) throws SQLException;

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 *            用户对象
	 * @throws SQLException
	 */
	void update(User user) throws SQLException;

	/**
	 * 校验用户名
	 * 
	 * @param userName
	 *            用户名
	 * @return true 用户名可用 false 用户名重复
	 * @throws SQLException
	 */
	boolean checkUserName(String userName) throws SQLException;
	

	/**
	 * 
	 * @param user 用户更新对象
	 * @param uid 对象uid
	 * @throws SQLException
	 */
	public void update(User user,String uid) throws SQLException ;
	/**
	 * 查询所有的用户
	 * @return 返回用户集合
	 * @throws SQLException
	 */
	List<User> findUserWithPage()throws SQLException ;
	/**
	 * 根据用户的id删除用户
	 * @param uid
	 * @throws SQLException
	 */
	void deleteUser(String uid)throws SQLException ;
}
