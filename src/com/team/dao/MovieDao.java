package com.team.dao;

import java.sql.SQLException;
import java.util.List;

import com.team.domain.Movie;

public interface MovieDao {
	/**
	 * 查找现在正在上映的电影
	 * @return 返回包含电影对象的集合
	 * @throws SQLException
	 */
	List<Movie> findNowPlaying() throws SQLException;

	/**
	 * 查找即将上映的电影
	 * @return 返回包含电影对象的集合
	 * @throws SQLException
	 */
	List<Movie> findComingSoon() throws SQLException;

	/**
	 * 根据电影id查找电影的详细信息
	 * @param mid 电影id
	 * @return 返回电影对象
	 * @throws SQLException
	 */
	Movie findMovieById(String mid) throws SQLException;

	/**
	 * 根据列表id查找本电影的详细信息
	 * @param cid   分类id
	 * @return 返回所有电影的详细信息集合
	 * @throws SQLException
	 */
	List<Movie> findListMovie(String cid) throws SQLException;

	/**
	 * 根据电影的名字查找电影
	 * @param movieName    电影的名字
	 * @return 电影对象
	 * @throws SQLException
	 */
	Movie findMovieByName(String movieName) throws SQLException;
	/**
	 * 根据电影分类id查询所有的电影个数
	 * @param cid 分类id
	 * @return 电影总个数
	 * @throws SQLException
	 */
	int findMovieCount(String cid) throws SQLException;
	/**
	 * 查找电影分页
	 * @param cid 分类的id
	 * @param num 第几页
	 * @return
	 * @throws SQLException 
	 */
	List<Movie> findListMovieWithPage(String cid, int num) throws SQLException;
	
	/**
	 * 查找所有的电影,分页
	 * @return
	 * @throws SQLException
	 */
	List<Movie> findAllMovieWithPage()throws SQLException;
	
	/**
	 * 根据id删除电影
	 * @param mid
	 * @throws SQLException
	 */
	void deleteMovie(String mid)throws SQLException;

	/**
	 * 增加电影
	 * @param movie
	 * @throws SQLException
	 */
	void addMovie(Movie movie)throws SQLException;

	/**
	 * 查找全部的电影
	 * @return
	 * @throws SQLException
	 */
	List<Movie> findAllMovie()throws SQLException;

}
