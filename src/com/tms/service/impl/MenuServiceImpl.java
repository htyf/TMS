package com.tms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tms.mapping.MenuMapper;
import com.tms.mapping.UserMapper;
import com.tms.model.Menu;
import com.tms.model.User;
import com.tms.service.MenuService;

@Service("menuService")  // MenuService menuService = new MenuServiceImpl();
public class MenuServiceImpl implements MenuService{
	@Resource
	private MenuMapper menuMapper;  
	@Override
	public Menu getMenuById(int menuId) {
		 return this.menuMapper.selectByPrimaryKey(menuId);
	}
	@Override
	public List<Menu> getAllMenu(int page,int rows) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("page", page);
		map.put("rows", rows);
		return this.menuMapper.getAllMenu(map);
	}
	
	//修改
	@Override
	public int updateByPrimaryKeySelective(Menu menu) {
		return this.menuMapper.updateByPrimaryKeySelective(menu);
	}
	
	@Override
	public int InsertSelective(Menu menu) {
		return this.menuMapper.insertSelective(menu);
	}
	
	//删除
	@Override
	public int deleteByPrimaryKey(int id) {
		return this.menuMapper.deleteByPrimaryKey(id);
	}
	
	//获取子级菜单的数据总条数
	@Override
	public int getAllCount() {
		return this.menuMapper.getAllCount();
	}
	
    
}
