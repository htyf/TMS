package com.tms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;




import org.springframework.stereotype.Service;


import com.tms.mapping.UserMapper;
import com.tms.model.User;
import com.tms.service.UserService;


@Service("userService")  //UserService userService = new UserServiceImpl();
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;  
	@Override
	public User getUserById(int userId) {
		 return this.userMapper.selectByPrimaryKey(userId);
	}
	@Override
	public List<User> getAllUser(int page,int rows) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("page", page);
		map.put("rows", rows);
		return this.userMapper.getAllUser(map);
	}
	@Override
	public int updateByPrimaryKeySelective(User user) {
		return this.userMapper.updateByPrimaryKeySelective(user);
	}
	@Override
	public int InsertSelective(User user) {
		return this.userMapper.insertSelective(user);
	}
	@Override
	public int deleteByPrimaryKey(int id) {
		return this.userMapper.deleteByPrimaryKey(id);
	}
	@Override
	public int getAllCount() {
		return this.userMapper.getAllCount();
	}
	

}
