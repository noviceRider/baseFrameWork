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
	 * �û���½
	 * @param po
	 * @return
	 */
	public Integer ifok(UserPo po) {
		//��ѯ�û����������Ƿ��д���ȷΪ1������Ϊ0
		Integer tif = userDao.ifok(po);
		if(tif == 1) {
			return 1;
		}
		else {
			return 0;
		}
	}

	/**
	 * �û�ע��
	 * @param po
	 * @return
	 */
	public Integer login(UserPo po) {
		// TODO Auto-generated method stub
		//��ȡ��ǰ�û������id����һ��Ϊ�µ��û���id
		Integer max = userDao.Max(po) + 1;
		po.setId(max);
		//�鿴�û����Ƿ��ظ�
		Integer repetition = userDao.repetition(po);
		//�û���û���ظ�
		if(repetition == 0) {
			return userDao.login(po);
		}else {
			return 0;
		}
	}

	/**
	 * ��ѯȫ���û�
	 * @param po
	 * @return
	 */
	public List<UserPo> query(UserPo po) {
		// TODO Auto-generated method stub
		return userDao.query(po);
	}

}
