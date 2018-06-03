package com.team.service;

import java.sql.SQLException;
import java.util.List;

import com.team.domain.Movie;
import com.team.domain.PageModel;

public interface MovieService {
	/**
	 * 即将上映的电影
	 * @return 电影集合
	 * @throws SQLException
	 */
	List<Movie> findComingSoon() throws SQLException;
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<Movie> findNowPlaying() throws SQLException;

	/**
	 * 查找电影根据点电影的id
	 * @param mid
	 * @return
	 * @throws SQLException
	 */
	Movie findMovieById(String mid)throws SQLException;

	/**
	 * 查找每个分类下的电影
	 * @param cid 分类id
	 * @return
	 * @throws SQLException
	 */
	List<Movie> findListMovie(String cid)throws SQLException;

	/**
	 * 根据电影的名称查找电影
	 * @param movieName
	 * @return
	 * @throws SQLException
	 */
	Movie findMovieByName(String movieName)throws SQLException;

	/**
	 * 查找电影分页
	 * @param cid
	 * @param num
	 * @return
	 * @throws SQLException
	 */
	PageModel findListMovieWithPage(String cid, int num)throws SQLException;
	//未完成分页
	List<Movie> findAllMovieWithPage()throws SQLException;
	
	/**
	 * 删除电影
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
	 * 发现全部的电影
	 * @return
	 * @throws SQLException
	 */
	List<Movie> findAllMovie()throws SQLException;


}
