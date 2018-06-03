package com.team.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.team.dao.CategoryDao;
import com.team.domain.Category;
import com.team.utils.JDBCUtils;
/**
 * 
 * @author maxu
 * @dete 2018/5/30
 *
 */
public class CategoryDaoImpl implements CategoryDao {
	
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	
	@Override
	public List<Category> findAllMovieCats() throws SQLException {
		String sql="select * from category";
		return qr.query(sql,new BeanListHandler<Category>(Category.class));
		
	}
}
