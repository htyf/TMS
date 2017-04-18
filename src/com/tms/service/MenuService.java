package com.tms.service;

import java.util.List;

import com.tms.model.Menu;
import com.tms.model.User;

public interface MenuService {
	public Menu getMenuById(int hid);
	
	public List<Menu> getAllMenu(int page,int rows); //获取所有父级菜单和对应的子级菜单
		
	public int getAllCount();
	
	public int updateByPrimaryKeySelective(Menu menu);
	
	public int InsertSelective(Menu menu);
	
	public int deleteByPrimaryKey(int id);
}
