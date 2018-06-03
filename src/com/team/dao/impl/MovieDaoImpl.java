package com.team.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.team.dao.MovieDao;
import com.team.domain.Movie;
import com.team.utils.JDBCUtils;

public class MovieDaoImpl implements MovieDao {

	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	@Override
	public List<Movie> findNowPlaying() throws SQLException {
		String sql = "SELECT * FROM movie WHERE  cid ='1'  LIMIT 0 ,6";
		return qr.query(sql, new BeanListHandler<Movie>(Movie.class));

	}

	@Override
	public List<Movie> findComingSoon() throws SQLException {
		String sql = "SELECT * FROM movie WHERE  cid='2'  LIMIT 0 ,6";
		return qr.query(sql, new BeanListHandler<Movie>(Movie.class));
	}

	@Override
	public Movie findMovieById(String mid) throws SQLException {
		String sql = "SELECT * FROM movie WHERE mid= ?";
		return qr.query(sql, new BeanHandler<Movie>(Movie.class), mid);
	}

	@Override
	public List<Movie> findListMovie(String cid) throws SQLException {
		String sql = "SELECT * FROM movie where cid=?";
		return qr.query(sql, new BeanListHandler<Movie>(Movie.class), cid);
	}

	@Override
	public Movie findMovieByName(String movieName) throws SQLException {
		String sql = "SELECT * FROM movie where mname=?";
		return qr.query(sql, new BeanHandler<Movie>(Movie.class), movieName);
	}

	@Override
	public int findMovieCount(String cid) throws SQLException {
		String sql = "SELECT count(*) FROM movie where cid=?";
		Long num = (Long) qr.query(sql, new ScalarHandler(), cid);
		return num.intValue();
	}

	@Override
	public List<Movie> findListMovieWithPage(String cid, int num) throws SQLException {
		String sql = "SELECT * FROM movie where cid=? limit ?,8";
		return qr.query(sql, new BeanListHandler<Movie>(Movie.class), cid, num);
	}

	@Override
	public List<Movie> findAllMovieWithPage() throws SQLException {
		String sql = "SELECT * FROM movie";
		return qr.query(sql, new BeanListHandler<Movie>(Movie.class));
	}

	@Override
	public void deleteMovie(String mid) throws SQLException {
		String sql = "delete from movie where mid=?";
		qr.update(sql, mid);
	}

	@Override
	public void addMovie(Movie movie) throws SQLException {
		String sql = "update movie set mid=?,mname=?,mprice=?,mimage=?,mstate=?,cid=?,video=?,playtime=?,actor=?";
		Object[] params = { movie.getMid(), movie.getMname(), movie.getMprice(), movie.getMimage(), movie.getMstate(),
				movie.getCid(), movie.getVideo(), movie.getPlaytime(), movie.getActor() };
		qr.update(sql, params);
	}

	@Override
	public List<Movie> findAllMovie() throws SQLException {
		String sql = "select mid,mname from movie";
		return qr.query(sql, new BeanListHandler<Movie>(Movie.class));
	}

}
