package com.cn.hnust.pojo;

import java.util.Date;

public class RUser {

	/**
	* <p>Title: RUser.java<／p>
	* <p>Description: <／p>
	* <p>Copyright: Copyright (c) 2007<／p>
	* <p>Company: LTGames<／p>
	* @author linrz
	* @date 2017年4月20日
	* @version 1.0
	*/
	private Integer userid;
	private String username;
	private String password;
	private Date createdate;
	private String userphonenumber;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getUserphonenumber() {
		return userphonenumber;
	}
	public void setUserphonenumber(String userphonenumber) {
		this.userphonenumber = userphonenumber;
	}
}
