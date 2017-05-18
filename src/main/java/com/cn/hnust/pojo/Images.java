package com.cn.hnust.pojo;

import java.util.Date;

public class Images {

	/**
	* <p>Title: Images.java<／p>
	* <p>Description: <／p>
	* <p>Copyright: Copyright (c) 2007<／p>
	* <p>Company: LTGames<／p>
	* @author linrz
	* @date 2017年4月19日
	* @version 1.0
	*/
    private Integer imageid;
	private String imagename;
	private String imagehref;
	private Integer articleid;
	public Integer getImageid() {
		return imageid;
	}
	public void setImageid(Integer imageid) {
		this.imageid = imageid;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getImagehref() {
		return imagehref;
	}
	public void setImagehref(String imagehref) {
		this.imagehref = imagehref;
	}
	public Integer getArticleid() {
		return articleid;
	}
	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}
}
