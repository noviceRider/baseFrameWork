package com.huibo.dao;

import java.util.List;

import com.huibo.po.UserPo;

public interface UserDao {

	//�û���½
	public Integer ifok(UserPo po);

	//�û�ע��
	public Integer login(UserPo po);

	//��ȡ���id
	public Integer Max(UserPo po);

	//�鿴�û����Ƿ��ظ�
	public Integer repetition(UserPo po);

	//��ѯȫ���û�
	public List<UserPo> query(UserPo po);

}
