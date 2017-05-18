package com.cn.hnust.dao;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.RUser;

public interface IRUserDao {
	public RUser selectRuserById(Integer userid);
	public void insertRUser(RUser user);
	public RUser selectRuserByUsernameAndPass(@Param("username") String username, @Param("password") String password);
	public RUser selectRUserByUsername(@Param("username") String username);
}
