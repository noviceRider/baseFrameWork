package com.huibo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huibo.po.UserPo;
import com.huibo.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * �û���½
	 * @param po
	 * @return
	 */
	@RequestMapping("/sdf")
	@ResponseBody
	public Map<String,Object> demo(UserPo po) {
		Map<String,Object> map = new HashMap<>();
		try {
			map.put("result", userService.ifok(po));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * �û�ע��
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Map<String,Object> login(UserPo po){
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			map.put("result", userService.login(po));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * ��ѯȫ���û�
	 */
	@RequestMapping("/query")
	@ResponseBody
	public Map<String,Object> query(UserPo po){
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			map.put("result", userService.query(po));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
}