
package com.tms.service;

import java.util.List;

import com.tms.model.Role;

public interface RoleService {
	public Role getRoleById(int roleId);
	
	public List<Role> getAllRole(int page,int row);
	
	public int getAllCount();
	
	public int updateByPrimaryKeySelective(Role role);
	
	public int InsertSelective(Role role);
	
	public int deleteByPrimaryKey(int id);
}
