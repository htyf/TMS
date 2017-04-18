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
import com.tms.model.EducationalShowOne;
import com.tms.service.EducationalService;

@Controller
@RequestMapping("/educational")
public class EducationalController {
	@Resource
	private EducationalService educationalService;
	
	//显示最新周的周考统计（默认显示）
		@RequestMapping("/showAllDataNearest")
		public void showAllDataNearest(HttpServletRequest request,
					HttpServletResponse response, Model model, 
					EducationalShowOne edu,int page,int rows) {
			//获取所有班级的周考成绩
			List<EducationalShowOne> educationalList = this.educationalService.getAllEducationalNearest((page-1)*rows,rows);
				
			int total = this.educationalService.getAllCount();
				
			Map<String, Object> jsonMap = new HashMap<String, Object>();
		       
			jsonMap.put("total", total);
		       
			jsonMap.put("rows", educationalList);
			
			try {
				response.getWriter().print(JSON.toJSONString(jsonMap));
			} catch (IOException e) {
				e.printStackTrace();
			}
				
		}
		
}
