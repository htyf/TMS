package com.tms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;




import org.springframework.stereotype.Service;

import com.tms.mapping.Sys_UserMapper;
import com.tms.model.Sys_User;
import com.tms.service.Sys_UserService;


@Service("sysUserService")  
public class Sys_UserServiceImpl implements Sys_UserService {
	 @Resource
	    private Sys_UserMapper sys_UserMapper;  
	@Override
	public Sys_User getUserById(int userId) {
		 return this.sys_UserMapper.selectByPrimaryKey(userId);
	}
	@Override
	public List<Sys_User> getAllUser(int page,int rows) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("page", page);
		map.put("rows", rows);
		return this.sys_UserMapper.getAllUser(map);
	}
	@Override
	public int updateByPrimaryKeySelective(Sys_User user) {
		return this.sys_UserMapper.updateByPrimaryKeySelective(user);
	}
	@Override
	public int InsertSelective(Sys_User user) {
		return this.sys_UserMapper.insertSelective(user);
	}
	@Override
	public int deleteByPrimaryKey(int id) {
		return this.sys_UserMapper.deleteByPrimaryKey(id);
	}
	@Override
	public int getAllCount() {
		return this.sys_UserMapper.getAllCount();
	}
	

}
