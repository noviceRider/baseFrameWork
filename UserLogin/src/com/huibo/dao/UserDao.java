package com.huibo.dao;

import java.util.List;

import com.huibo.po.UserPo;

public interface UserDao {

	//用户登陆
	public Integer ifok(UserPo po);

	//用户注册
	public Integer login(UserPo po);

	//获取最大id
	public Integer Max(UserPo po);

	//查看用户名是否重复
	public Integer repetition(UserPo po);

	//查询全部用户
	public List<UserPo> query(UserPo po);

}
