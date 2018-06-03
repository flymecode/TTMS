package com.team.domain;

public class OrderItem {

	private String oiid;// 购物条目的信息
	
	private Movie movie;// 电影的信息
	private Hall hall;// 演出厅的信息
	private String time;//电影播放时间
	private int num;// 电影票的数量
	private double subTotal;// 小计
	private String seat;// 座位的信息
	private String oid;//订单的id
	private String hname;//演出厅的名字
	private String mid;

	
	public OrderItem() {
		super();
	}
	
	public OrderItem(String oiid, Movie movie, Hall hall, String time, int num, double subTotal, String seat,
			String oid, String hname) {
		super();
		this.oiid = oiid;
		this.movie = movie;
		this.hall = hall;
		this.time = time;
		this.num = num;
		this.subTotal = subTotal;
		this.seat = seat;
		this.oid = oid;
		this.hname = hname;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getHname() {
		return hname;
	}






	public void setHname(String hname) {
		this.hname = hname;
	}






	public String getOid() {
		return oid;
	}




	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getOiid() {
		return oiid;
	}
	public void setOiid(String oiid) {
		this.oiid = oiid;
	}
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	
	
	
}
