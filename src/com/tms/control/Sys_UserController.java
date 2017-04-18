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
import com.tms.model.Sys_User;
import com.tms.service.Sys_UserService;


@Controller
@RequestMapping("/sysUser")
public class Sys_UserController {
	@Resource
	private Sys_UserService sysUserService;

	@RequestMapping("/addOneUser")
	public void addOneUser(HttpServletRequest request,
			HttpServletResponse response, Model model, Sys_User u){
		Map<String,Object> m = model.asMap();
		Sys_User user = (Sys_User) m.get("user");
		String result = this.sysUserService.InsertSelective(user)>0?"0":"1";
		try {
			response.getWriter().print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model, Sys_User u) {
		int userId = Integer.parseInt(request.getParameter("id"));
		Sys_User user = this.sysUserService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}

	
	/*
	 * page锛氶〉鐮侊紝璧峰鍊�1銆�
       rows锛氭瘡椤垫樉绀鸿銆�
       
       
       total:  select count(1) from 琛ㄥ悕锛�
	 * 
	 * 
	 */
	
	@RequestMapping("/showAllUser")
	public void showAllData(HttpServletRequest request,
			HttpServletResponse response, Model model, Sys_User u,int page,int rows) {
		List<Sys_User> user = this.sysUserService.getAllUser((page-1)*rows,rows);
		int total = this.sysUserService.getAllCount();
		Map<String, Object> jsonMap = new HashMap<String, Object>();//瀹氫箟map  
        jsonMap.put("total", total);//total閿�瀛樻斁鎬昏褰曟暟锛屽繀椤荤殑  
        jsonMap.put("rows", user);//rows閿�瀛樻斁姣忛〉璁板綍 list  
		try {
			response.getWriter().print(JSON.toJSONString(jsonMap));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/UpdateForUser")
	public void UpdateForUser(HttpServletRequest request,
			HttpServletResponse response, Model model, Sys_User u) {
		String num = this.sysUserService.updateByPrimaryKeySelective(u)>0?"0":"1";
		try {
			response.getWriter().print(num);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@RequestMapping("/deleteForUser")
	public void DeleteForUser(HttpServletRequest request,
			HttpServletResponse response, String id){
		
		String num = this.sysUserService.deleteByPrimaryKey(Integer.parseInt(id))>0?"0":"1";
		try {
			response.getWriter().print(num);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}