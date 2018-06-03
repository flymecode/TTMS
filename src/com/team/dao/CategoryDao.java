package com.team.dao;

import java.sql.SQLException;
import java.util.List;

import com.team.domain.Category;

public interface CategoryDao {
	/**
	 * 查找电影分类的所有分类信息
	 * 
	 * @return 返回一个分类的集合
	 * @throws SQLException
	 */
	public List<Category> findAllMovieCats() throws SQLException;
}
