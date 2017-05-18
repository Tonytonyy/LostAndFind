package com.cn.hnust.vo;

import java.util.List;

import com.cn.hnust.pojo.Article;

public class ArticlePage {

	/**
	* <p>Title: ArticlePage.java<／p>
	* <p>Description: <／p>
	* <p>Copyright: Copyright (c) 2007<／p>
	* <p>Company: LTGames<／p>
	* @author linrz
	* @date 2017年5月3日
	* @version 1.0
	*/
	private Integer totalRecords;
	private Integer totalPage;
	private Integer currentPage;
	private Integer pageRecord;
	private List<Article> pageList;
	public Integer getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageRecord() {
		return pageRecord;
	}
	public void setPageRecord(Integer pageRecord) {
		this.pageRecord = pageRecord;
	}
	public List<Article> getPageList() {
		return pageList;
	}
	public void setPageList(List<Article> pageList) {
		this.pageList = pageList;
	}
}
