package com.team.domain;

/**
 * 电影模型
 * @author maxu
 *
 */
public class Movie {
	
	private String mid;//电影id
	private String mname;//电影名称
	private String mprice;//电影价格
	private String mdescription;//电影描述
	private String mimage;//电影图片
	private int mstate;//电影状态
	private String video;//电影视频路径
	private String playtime;//电影播放时长
	private String actor;//电影演员
	private String cid;//电影的分类id
	
	
	public Movie() {
		super();
	}

	
	public String getVideo() {
		return video;
	}


	public void setVideo(String video) {
		this.video = video;
	}


	public String getPlaytime() {
		return playtime;
	}


	public void setPlaytime(String playtime) {
		this.playtime = playtime;
	}


	public String getActor() {
		return actor;
	}


	public void setActor(String actor) {
		this.actor = actor;
	}


	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMprice() {
		return mprice;
	}
	public void setMprice(String mprice) {
		this.mprice = mprice;
	}
	public String getMdescription() {
		return mdescription;
	}
	public void setMdescription(String mdescription) {
		this.mdescription = mdescription;
	}
	public String getMimage() {
		return mimage;
	}
	public void setMimage(String mimage) {
		this.mimage = mimage;
	}
	public int getMstate() {
		return mstate;
	}
	public void setMstate(int mstate) {
		this.mstate = mstate;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	
}
