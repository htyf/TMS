package com.tms.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.tms.model.Menu;
import com.tms.model.User;
import com.tms.service.MenuService;
import com.tms.service.UserService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	@Resource
	private MenuService menuService;

	@RequestMapping("/addOneMenu")
	public void addOneUser(HttpServletRequest request,
			HttpServletResponse response, Model model, Menu m){
		Map<String,Object> map = model.asMap();
		Menu menu = (Menu) map.get("menu");
		String result = this.menuService.InsertSelective(menu)>0 ? "0" : "1";
		try {
			response.getWriter().print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/showMenu")
	public String toIndex(HttpServletRequest request, Model model, Menu m) {
		int menuId = Integer.parseInt(request.getParameter("id"));
		Menu menu = this.menuService.getMenuById(menuId);
		model.addAttribute("menu", menu);
		return "showMenu";
	}

	@RequestMapping("/showAllMenu")
	public void showAllData(HttpServletRequest request,
			HttpServletResponse response, Model model, Menu m,int page,int rows) {
		List<Menu> menu = this.menuService.getAllMenu((page-1)*rows,rows);
		int total = this.menuService.getAllCount();
		Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total", total);
        jsonMap.put("rows", menu);
		try {
			response.getWriter().print(JSON.toJSONString(jsonMap));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/updateForMenu")
	public void UpdateForUser(HttpServletRequest request,
			HttpServletResponse response, Model model, Menu m) {
		String num = this.menuService.updateByPrimaryKeySelective(m)>0?"0":"1";
		try {
			response.getWriter().write(num);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@RequestMapping("/deleteForMenu")
	public void deleteForMenu(HttpServletRequest request,
			HttpServletResponse response, String id){
		//判断是否删除成功，大于0则删除成功
		String num = this.menuService.deleteByPrimaryKey(Integer.parseInt(id))>0?"0":"1";
		try {
			
			response.getWriter().print(num);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
