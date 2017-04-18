
package com.tms.mapping;


import java.util.List;
import java.util.Map;

import com.tms.model.Role;


public interface RoleMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Role record);
   
	int insertSelective(Role record);

	int getAllCount();
	
	Role selectByPrimaryKey(Integer id);

	List<Role> getAllRole(Map<String,Integer> map);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);
}