package com.huibo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huibo.dao.UserDao;
import com.huibo.po.UserPo;
@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	/**
	 * 用户登陆
	 * @param po
	 * @return
	 */
	public Integer ifok(UserPo po) {
		//查询用户名和密码是否有错，正确为1，错误为0
		Integer tif = userDao.ifok(po);
		if(tif == 1) {
			return 1;
		}
		else {
			return 0;
		}
	}

	/**
	 * 用户注册
	 * @param po
	 * @return
	 */
	public Integer login(UserPo po) {
		// TODO Auto-generated method stub
		//获取当前用户的最大id并加一作为新的用户的id
		Integer max = userDao.Max(po) + 1;
		po.setId(max);
		//查看用户名是否重复
		Integer repetition = userDao.repetition(po);
		//用户名没有重复
		if(repetition == 0) {
			return userDao.login(po);
		}else {
			return 0;
		}
	}

	/**
	 * 查询全部用户
	 * @param po
	 * @return
	 */
	public List<UserPo> query(UserPo po) {
		// TODO Auto-generated method stub
		return userDao.query(po);
	}

}
