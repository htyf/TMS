package com.tms.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.tms.model.Menu;
import com.tms.service.MenuAndTitleService;

@Controller
@RequestMapping("/menuAndTitle")
public class MenuAndTitle {
	@Resource
	private MenuAndTitleService menuAndTitleService;
	
	@RequestMapping("/initMenu")
	public void initMenu(HttpServletRequest request,
			HttpServletResponse response){
		List<Menu> list = menuAndTitleService.getMenu();
		String s = JSON.toJSONString(list);
		try {
			response.getWriter().write(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ������˵�����������С����
	 * @param request
	 * @param response
	 */
	@RequestMapping("/initTitle")
	public void initTitle(HttpServletRequest request,
			HttpServletResponse response){
		List<Menu> list = menuAndTitleService.getTitle();
		String s = JSON.toJSONString(list);
		try {
			response.getWriter().write(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/findHeadMenu")
	public void findHeadMenu(HttpServletRequest request,
			HttpServletResponse response,String hid){
		System.out.println("ok"+hid);
	}
	
	@RequestMapping("/findTitleMenu")
	public void findTitleMenu(HttpServletRequest request,
			HttpServletResponse response,String tid){
		System.out.println("ok"+tid);
	}
}
