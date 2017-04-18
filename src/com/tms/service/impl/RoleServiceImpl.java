
package com.tms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;




import org.springframework.stereotype.Service;

import com.tms.mapping.RoleMapper;
import com.tms.model.Role;
import com.tms.service.RoleService;


@Service("roleService")  
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleMapper roleMapper;  
	@Override
	public Role getRoleById(int roleId) {
		 return this.roleMapper.selectByPrimaryKey(roleId);
	}
	@Override
	public List<Role> getAllRole(int page,int rows) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("page", page);
		map.put("rows", rows);
		return this.roleMapper.getAllRole(map);
	}
	@Override
	public int updateByPrimaryKeySelective(Role role) {
		return this.roleMapper.updateByPrimaryKeySelective(role);
	}
	@Override
	public int InsertSelective(Role role) {
		return this.roleMapper.insertSelective(role);
	}
	@Override
	public int deleteByPrimaryKey(int id) {
		return this.roleMapper.deleteByPrimaryKey(id);
	}
	@Override
	public int getAllCount() {
		return this.roleMapper.getAllCount();
	}
	

}
