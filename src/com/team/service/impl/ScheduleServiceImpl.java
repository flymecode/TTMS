package com.team.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team.dao.HallDao;
import com.team.dao.MovieDao;
import com.team.dao.ScheduleDao;
import com.team.dao.impl.HallDaoImpl;
import com.team.dao.impl.MovieDaoImpl;
import com.team.dao.impl.ScheduleDaoImpl;
import com.team.domain.Hall;
import com.team.domain.Movie;
import com.team.domain.OrderItem;
import com.team.domain.Schedule;
import com.team.service.ScheduleService;
import com.team.utils.UUIDUtils;

public class ScheduleServiceImpl implements ScheduleService{

	//调用电影计划表
	ScheduleDao sd = new ScheduleDaoImpl();
	//调用电影厅dao
	HallDao hd = new HallDaoImpl();
	//调用电影表的Dao
	MovieDao md = new MovieDaoImpl();
	@Override
	public List<Schedule> findPlayInfo(String mid) throws SQLException {
		//每场电影的详细播出信息
		List<Schedule> playinfo = new ArrayList<>();
		
		//根据电影mid获取到所有的电影详情
		List<Schedule> list = sd.findPlayInfo(mid);
		
		for (Schedule schedule : list) {
			//获取到每个演出计划中电影厅的id
			String hid = schedule.getHid();
			Hall hall = hd.findHallByHid(hid);
			schedule.setHall(hall);
			playinfo.add(schedule);
		}		
		return playinfo;
	}
	
	@Override
	public Schedule findPlayInfoById(String sid) throws SQLException {
		//演出计划
		Schedule schedule = sd.findPlayInfoById(sid);
		//电影信息
		Movie m = md.findMovieById(schedule.getMid());
		//演出厅的信息
		Hall h = hd.findHallByHid(schedule.getHid());
		schedule.setHall(h);
		schedule.setMovie(m);
		return schedule;
	}

	@Override
	public OrderItem findOrderInfo(String sid) throws SQLException {
		OrderItem orderItem = new OrderItem();
		Schedule schedule = sd.findPlayInfoById(sid);
		//根据电影id查找电影的详细
		Movie movie = md.findMovieById(schedule.getMid());
		//查找演出厅的详细信息
		Hall hall = hd.findHallByHid(schedule.getHid());
		orderItem.setHall(hall);
		orderItem.setMovie(movie);
		orderItem.setTime(schedule.getTime());
		orderItem.setOiid(UUIDUtils.getId());
		//返回订单条目,还差小计和座位
		return orderItem;
	}

	@Override
	public List<Schedule> findAllSchedule() throws SQLException {
		
		List<Schedule> schedule = sd.findAllSchedule();
		for (Schedule s : schedule) {
			Movie movie = md.findMovieById(s.getMid());
			Hall hall = hd.findHallByHid(s.getHid());
			s.setHall(hall);
			s.setMovie(movie);
		}
		return schedule;
	}

	@Override
	public void addSchedule(Schedule schedule) throws SQLException {
		sd.addSchedule(schedule);
	}

}
