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
import com.tms.model.Power;
import com.tms.service.PowerService;

@Controller
@RequestMapping("/power")
public class PowerController {
	@Resource
	private PowerService powerService;

	@RequestMapping("/addOnePower")
	public void addOnePower(HttpServletRequest request, HttpServletResponse response, Model model, Power u) {
		Map<String, Object> m = model.asMap();
		Power power = (Power) m.get("power");
		String result = this.powerService.InsertSelective(power) > 0 ? "0" : "1";
		try {
			response.getWriter().print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/showPower")
	public String toIndex(HttpServletRequest request, Model model, Power u) {
		int powerId = Integer.parseInt(request.getParameter("power_id"));
		Power power = this.powerService.getPowerById(powerId);
		model.addAttribute("power", power);
		return "showPower";
	}

	/*
	 * page锛氶〉鐮侊紝璧峰鍊�1銆� rows锛氭瘡椤垫樉绀鸿銆�
	 * 
	 * 
	 * total: select count(1) from 琛ㄥ悕锛�
	 * 
	 * 
	 */

	@RequestMapping("/showAllPower")
	public void showAllData(HttpServletRequest request, HttpServletResponse response, Model model, Power u, int page,
			int rows) {
		List<Power> power = this.powerService.getAllPower((page - 1) * rows, rows);
		int total = this.powerService.getAllCount();
		Map<String, Object> jsonMap = new HashMap<String, Object>();// 瀹氫箟map
		jsonMap.put("total", total);// total閿�瀛樻斁鎬昏褰曟暟锛屽繀椤荤殑
		jsonMap.put("rows", power);// rows閿�瀛樻斁姣忛〉璁板綍 list
		try {
			response.getWriter().print(JSON.toJSONString(jsonMap));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/UpdateForPower")
	public void UpdateForPower(HttpServletRequest request, HttpServletResponse response, Model model, Power u) {
		String num = this.powerService.updateByPrimaryKeySelective(u) > 0 ? "0" : "1";
		try {
			response.getWriter().print(num);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/deleteForPower")
	public void DeleteForPower(HttpServletRequest request, HttpServletResponse response, String id) {
		String num = this.powerService.deleteByPrimaryKey(Integer.parseInt(id)) > 0 ? "0" : "1";
		try {
			response.getWriter().print(num);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}