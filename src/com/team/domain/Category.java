package com.team.domain;

/**
 * 电影分类模型
 * 
 * @author maxu
 *
 */
public class Category {

	private String cid;// 电影分类id
	private String cname;// 电影分类名称

	public Category() {
		super();
	}

	public Category(String cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

}
