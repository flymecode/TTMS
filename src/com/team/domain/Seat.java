package com.team.domain;

public class Seat {
	private String seid;
	private int row;
	private int column;
	private String state;
	private String hid;
	private String oid;
	

	public Seat() {
		super();
	}
	
	

	public Seat(String seid, int row, int column, String state, String hid,String oid) {
		super();
		this.seid = seid;
		this.row = row;
		this.column = column;
		this.state = state;
		this.hid = hid;
		this.oid = oid;
	}



	public String getOid() {
		return oid;
	}



	public void setOid(String oid) {
		this.oid = oid;
	}



	public String getSeid() {
		return seid;
	}

	public void setSeid(String seid) {
		this.seid = seid;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}
	
	
	
}
