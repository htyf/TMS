package com.tms.service;

import java.util.List;

import com.tms.model.Sys_User;


public interface Sys_UserService {
	public Sys_User getUserById(int userId);
	
	public List<Sys_User> getAllUser(int page,int row);
	
	public int getAllCount();
	
	public int updateByPrimaryKeySelective(Sys_User user);
	
	public int InsertSelective(Sys_User user);
	
	public int deleteByPrimaryKey(int id);
}
