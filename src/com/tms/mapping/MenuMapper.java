package com.tms.mapping;

import java.util.List;
import java.util.Map;

import com.tms.model.Menu;

public interface MenuMapper {
	
	List<Menu> getAllMenu(Map<String,Integer> map);  //获取父级菜单和其对应的子级菜单
		
	int getAllCount();  //获取子级菜单表中的数据数
	
	int deleteByPrimaryKey(Integer id);  //根据id值删除对应的子级菜单
	
	int updateByPrimaryKeySelective(Menu record);  // 根据指定的id修改对应的子级菜单名
	
	int updateByPrimaryKey(Menu record);   // 根据指定的id修改对应的子级菜单名
	
	int insert(Menu record);
	
	int insertSelective(Menu record);
	
	Menu selectByPrimaryKey(Integer id);
	
	
  
}
