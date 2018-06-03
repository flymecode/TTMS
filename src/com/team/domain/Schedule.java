package com.team.domain;


/**
 * 演出计划表
 * @author maxu
 *
 */
public class Schedule {
	
	private String sid;//演出计划表
	private String mid;//电影id
	private String hid;//电影厅id
	private String time;//电影播出时间
	private Hall hall;//保存演出厅信息
	private Movie movie;//保存电影信息
	
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Hall getHall() {
		return hall;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
