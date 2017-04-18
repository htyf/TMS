package com.tms.mapping;


import java.util.List;
import java.util.Map;

import com.tms.model.Sys_User;


public interface Sys_UserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Sys_User record);

	int insertSelective(Sys_User record);

	int getAllCount();
	Sys_User selectByPrimaryKey(Integer id);

	List<Sys_User> getAllUser(Map<String,Integer> map);

	int updateByPrimaryKeySelective(Sys_User record);

	int updateByPrimaryKey(Sys_User record);
}