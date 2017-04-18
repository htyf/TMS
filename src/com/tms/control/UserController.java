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
import com.tms.model.User;
import com.tms.model.WeeklyTime;
import com.tms.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;

	@RequestMapping("/addOneUser")
	public void addOneUser(HttpServletRequest request,
			HttpServletResponse response, Model model, User u){
		Map<String,Object> m = model.asMap();
		User user = (User) m.get("user");
		String result = this.userService.InsertSelective(user)>0?"0":"1";
		try {
			response.getWriter().print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model, User u) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}

	
	/*
	 * page閿涙岸銆夐惍渚婄礉鐠у嘲顬婇崐锟�1閵嗭拷
       rows閿涙碍鐦℃い鍨▔缁�楦款攽閵嗭拷
        
       total:  select count(1) from 鐞涖劌鎮曢敍锟�
	 */
	@RequestMapping("/showAllUser")
	public void showAllData(HttpServletRequest request,
			HttpServletResponse response, Model model, User u,int page,int rows,WeeklyTime w) {
		List<User> user = this.userService.getAllUser((page-1)*rows,rows);
		int total = this.userService.getAllCount();
		Map<String, Object> jsonMap = new HashMap<String, Object>();//鐎规矮绠焟ap  
        jsonMap.put("total", total);//total闁匡拷鐎涙ɑ鏂侀幀鏄忣唶瑜版洘鏆熼敍灞界箑妞よ崵娈�  
        jsonMap.put("rows", user);//rows闁匡拷鐎涙ɑ鏂佸В蹇涖�夌拋鏉跨秿 list  
		try {
			response.getWriter().print(JSON.toJSONString(jsonMap));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/UpdateForUser")
	public void UpdateForUser(HttpServletRequest request,
			HttpServletResponse response, Model model, User u) {
		String num = this.userService.updateByPrimaryKeySelective(u)>0?"0":"1";
		try {
			response.getWriter().print(num);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@RequestMapping("/deleteForUser")
	public void DeleteForUser(HttpServletRequest request,
			HttpServletResponse response, String id){
		String num = this.userService.deleteByPrimaryKey(Integer.parseInt(id))>0?"0":"1";
		try {
			response.getWriter().print(num);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}