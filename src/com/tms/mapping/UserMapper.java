package com.tms.mapping;

import java.util.List;
import java.util.Map;

import com.tms.model.User;


public interface UserMapper {
	int deleteByPrimaryKey(Integer id);
	
	int insert(User record);
	
	int insertSelective(User record);
	
	int getAllCount();
	
	User selectByPrimaryKey(Integer id);
	
	List<User> getAllUser(Map<String,Integer> map);
	
	int updateByPrimaryKeySelective(User record);
	
	int updateByPrimaryKey(User record);
  
}
