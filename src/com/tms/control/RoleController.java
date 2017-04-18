
package com.tms.control;

import java.io.IOException;
import java.util.ArrayList;
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
import com.tms.model.Role;
import com.tms.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Resource
	private RoleService roleService;

	@RequestMapping("/addOneRole")
	public void addOneRole(HttpServletRequest request, HttpServletResponse response, Model model, Role r) {
		Map<String, Object> m = model.asMap();
		Role role = (Role) m.get("role");
		String result = this.roleService.InsertSelective(role) > 0 ? "0" : "1";
		try {
			response.getWriter().print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/showRole")
	public String toIndex(HttpServletRequest request, Model model, Role r) {
		int roleId = Integer.parseInt(request.getParameter("role_id"));
		Role role = this.roleService.getRoleById(roleId);
		model.addAttribute("role", role);
		return "showRole";
	}

	/*
	 * page閿涙岸銆夐惍渚婄礉鐠у嘲顬婇崐锟�1閵嗭拷 rows閿涙碍鐦℃い鍨▔缁�楦款攽閵嗭拷
	 * 
	 * 
	 * total: select count(1) from 鐞涖劌鎮曢敍锟�
	 * 
	 * 
	 */

	@RequestMapping("/showAllRole")
	public void showAllData(HttpServletRequest request, HttpServletResponse response, Model model, Role r, int page,
			int rows) {
		List<Role> role = this.roleService.getAllRole((page - 1) * rows, rows);
		int total = this.roleService.getAllCount();
		Map<String, Object> jsonMap = new HashMap<String, Object>();// 鐎规矮绠焟ap
		jsonMap.put("total", total);// total闁匡拷鐎涙ɑ鏂侀幀鏄忣唶瑜版洘鏆熼敍灞界箑妞よ崵娈�
		jsonMap.put("rows", role);// rows闁匡拷鐎涙ɑ鏂佸В蹇涖�夌拋鏉跨秿 list
		try {
			response.getWriter().print(JSON.toJSONString(jsonMap));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/UpdateForRole")
	public void UpdateForRole(HttpServletRequest request, HttpServletResponse response, Model model, Role r) {
		String num = this.roleService.updateByPrimaryKeySelective(r) > 0 ? "0" : "1";
		try {
			response.getWriter().print(num);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/deleteForRole")
	public void DeleteForRole(HttpServletRequest request, HttpServletResponse response, String id) {
		String num = this.roleService.deleteByPrimaryKey(Integer.parseInt(id)) > 0 ? "0" : "1";
		try {
			response.getWriter().print(num);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}