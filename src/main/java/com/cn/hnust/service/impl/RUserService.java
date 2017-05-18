package com.cn.hnust.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.IRUserDao;
import com.cn.hnust.pojo.RUser;
import com.cn.hnust.service.IRUserService;


@Service("ruserService")
public class RUserService implements IRUserService {
	/**
	* <p>Title: RUserService.java<／p>
	* <p>Description: <／p>
	* <p>Copyright: Copyright (c) 2007<／p>
	* <p>Company: LTGames<／p>
	* @author linrz
	* @date 2017年4月20日
	* @version 1.0
	*/
    @Resource
	private IRUserDao ruserDao; 

	public void insertUser(RUser user) {
		// TODO Auto-generated method stub
		ruserDao.insertRUser(user);
	}

	public RUser selectRuserById(Integer userid) {
		// TODO Auto-generated method stub
		return ruserDao.selectRuserById(userid);
	}

	public RUser selectRUserByNameAndPass(String username, String password) {
		// TODO Auto-generated method stub
		return ruserDao.selectRuserByUsernameAndPass(username, password);
	}

	public RUser selectRUserByName(String username) {
		// TODO Auto-generated method stub
		return ruserDao.selectRUserByUsername(username);
	}

	
}
