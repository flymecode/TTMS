package com.team.domain;

import java.util.Date;
import java.util.List;

public class Order {
	private String oid;//订单id
	private	String uid;//用户id
	private int state;//订单的状态
	private Date orderTime;//订单的日期
	private double total = 0;//订单的总价
	
	private List<OrderItem>  orderItem;//每个订单包含的条目

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public String getOid() {
		return oid;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}

	
}
