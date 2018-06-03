package com.team.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.team.dao.CategoryDao;
import com.team.dao.impl.CategoryDaoImpl;
import com.team.domain.Category;
import com.team.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	CategoryDao cd = new CategoryDaoImpl();
	
	@Override
	public List<Category> findAllMovieCats() throws SQLException {
		return cd.findAllMovieCats();
		
	}
	

}
