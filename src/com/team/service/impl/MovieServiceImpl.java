package com.team.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.team.dao.MovieDao;
import com.team.dao.impl.MovieDaoImpl;
import com.team.domain.Movie;
import com.team.domain.PageModel;
import com.team.service.MovieService;

public class MovieServiceImpl implements MovieService {

	MovieDao md = new MovieDaoImpl();
	
	@Override
	public List<Movie> findComingSoon() throws SQLException {
		return md.findComingSoon();
	}

	@Override
	public List<Movie> findNowPlaying() throws SQLException {
		return md.findNowPlaying();
	}

	@Override
	public Movie findMovieById(String mid) throws SQLException {
		return md.findMovieById(mid);
	}

	@Override
	public List<Movie> findListMovie(String cid) throws SQLException {
		return md.findListMovie(cid);
	}

	@Override
	public Movie findMovieByName(String movieName) throws SQLException {
		return md.findMovieByName(movieName);
	}

	@Override
	public PageModel findListMovieWithPage(String cid,int num) throws SQLException {
		int totalRecord = md.findMovieCount(cid);
		PageModel page = new PageModel(num, totalRecord, 8);
		List<Movie> list = md.findListMovieWithPage(cid, num);
		page.setList(list);
		page.setUrl("MovieServlet?method=findListMovieWithPage&cid="+cid);
		return page;
	}

	@Override
	public List<Movie> findAllMovieWithPage() throws SQLException {
		return md.findAllMovieWithPage();
	}

	@Override
	public void deleteMovie(String mid) throws SQLException {
		md.deleteMovie(mid); 
	}

	@Override
	public void addMovie(Movie movie) throws SQLException {
		md.addMovie(movie);
	}

	@Override
	public List<Movie> findAllMovie() throws SQLException {
		return md.findAllMovie();
	}

}
