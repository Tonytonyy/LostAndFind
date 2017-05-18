package com.cn.hnust.service;

import com.cn.hnust.pojo.RUser;

public interface IRUserService {
    public RUser selectRuserById(Integer userid);
    public void insertUser(RUser user);
    public RUser selectRUserByNameAndPass(String username,String password);
    public RUser selectRUserByName(String username);
}
