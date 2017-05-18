package com.cn.hnust.pojo;

import java.util.Date;
import java.util.List;

public class Article {

	/**
	* <p>Title: Article.java<／p>
	* <p>Description: <／p>
	* <p>Copyright: Copyright (c) 2007<／p>
	* <p>Company: LTGames<／p>
	* @author linrz
	* @date 2017年4月20日
	* @version 1.0
	*/
	private Integer articleid;
	private Integer userid;
	private String articletitle;
	private String articleadress;
	private String articlebody;
	private Date  createdate;
	private Integer type;
	private List<Images> imageslist;
	public Integer getArticleid() {
		return articleid;
	}
	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}
	public String getArticletitle() {
		return articletitle;
	}
	public void setArticletitle(String articletitle) {
		this.articletitle = articletitle;
	}
	public String getArticleadress() {
		return articleadress;
	}
	public void setArticleadress(String articleadress) {
		this.articleadress = articleadress;
	}
	public String getArticlebody() {
		return articlebody;
	}
	public void setArticlebody(String articlebody) {
		this.articlebody = articlebody;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public List<Images> getImageslist() {
		return imageslist;
	}
	public void setImageslist(List<Images> imageslist) {
		this.imageslist = imageslist;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
}
