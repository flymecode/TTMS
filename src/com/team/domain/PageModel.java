package com.team.domain;

import java.util.List;

/**
 * 分页模型
 * 
 * @author maxu
 *
 */
public class PageModel {

	private int curPage;// 当前页
	private int totalRecord;// 总记录数
	private int totalPage;// 总页数

	private int prePageNum;// 上一页 *
	private int nextPageNum;// 下一页
	private int pageSize = 8;// 每页数据数
	private int startIndex;// 开始位置

	private List list;
	private String url;

	private int startPage;// 开始页码
	private int endPage;// 结束页码

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public PageModel(int curPage, int totalRecord, int pageSize) {
		this.curPage = curPage;
		this.totalRecord = totalRecord;
		this.pageSize = pageSize;
		this.startIndex = (curPage - 1) * pageSize;
		this.totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1;

		startPage = curPage - 4; // 5
		endPage = curPage + 4; // 13
		// 看看总页数够不够9页
		if (totalPage > 9) {
			// 超过了9页
			if (startPage < 1) {
				startPage = 1;
				endPage = startPage + 8;
			}
			if (endPage > totalPage) {
				endPage = totalPage;
				startPage = endPage - 8;
			}
		} else {
			// 不够9页
			startPage = 1;
			endPage = totalPage;
		}
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public void setPrePageNum(int prePageNum) {
		this.prePageNum = prePageNum;
	}

	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getPrePageNum() {
		prePageNum = curPage - 1;
		if (prePageNum < 1) {
			prePageNum = 1;
		}
		return prePageNum;
	}

	public int getNextPageNum() {
		nextPageNum = curPage + 1;
		if (nextPageNum > totalPage) {
			nextPageNum = totalPage;
		}
		return nextPageNum;
	}

}
