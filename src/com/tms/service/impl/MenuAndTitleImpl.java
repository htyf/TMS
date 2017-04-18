package com.tms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tms.mapping.MenuAndTitleMapper;
import com.tms.model.Menu;
import com.tms.service.MenuAndTitleService;

@Service("menuAndTitleService")
public class MenuAndTitleImpl implements MenuAndTitleService{
    @Resource
    private MenuAndTitleMapper menuAndTitleMapper;
	
    @Override
	public List<Menu> getMenu() {
		List<Menu> list = menuAndTitleMapper.getAllMenu();
		return list;
	}

	@Override
	public List<Menu> getTitle() {
         List<Menu> list = menuAndTitleMapper.getAllTitle();
		return list;
	}
}
