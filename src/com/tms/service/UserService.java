package com.tms.service;

import java.util.List;

import com.tms.model.User;

public interface UserService{
	public User getUserById(int userId);
	
	public List<User> getAllUser(int page,int rows);
	
	public int getAllCount();
	
	public int updateByPrimaryKeySelective(User user);
	
	public int InsertSelective(User user);
	
	public int deleteByPrimaryKey(int id);
	
}
