package com.team.service;

import java.sql.SQLException;
import java.util.List;

import com.team.domain.Category;

public interface CategoryService {

	/**
	 * 发现所有的电影分类信息
	 * @return
	 * @throws SQLException
	 */
	List<Category> findAllMovieCats() throws SQLException;
	

}
