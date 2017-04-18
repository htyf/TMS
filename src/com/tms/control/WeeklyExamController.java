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
import com.tms.model.WeeklyExamShowOne;
import com.tms.model.WeeklyTime;
import com.tms.service.WeeklyExamService;


@Controller
@RequestMapping("/weeklyExam")
public class WeeklyExamController {
	private static final String Service = null;
	@Resource
	private WeeklyExamService weeklyExamService;
	
	@RequestMapping("/showClassStudentScore")
	public void showClassStudentScore(HttpServletRequest request,
			HttpServletResponse response, Model model, 
			WeeklyExamShowOne wexam,int page,int rows,
			String classname,String weeklyyear,String weeklymonth,String weeklyday) {
		List<WeeklyExamShowOne> weeklyExamList = this.weeklyExamService.getAllClassStudentWeekScore((page-1)*rows,rows,classname,weeklyyear,weeklymonth,weeklyday);
		int total = this.weeklyExamService.getAllCount();
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", total);
		jsonMap.put("rows", weeklyExamList);
		try {
			response.getWriter().print(JSON.toJSONString(jsonMap));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/showAllDataByWeek")
	public void showAllDataByWeek(HttpServletRequest request,
			HttpServletResponse response, Model model, 
			WeeklyExamShowOne wexam,Integer page,Integer rows,
			String weeklyyear,String weeklymonth,String weeklyday) {
		List<WeeklyExamShowOne> weeklyExamList = this.weeklyExamService.getAllClassWeeklyExamByWeek((page-1)*rows,rows,weeklyyear,weeklymonth,weeklyday);
		int total = this.weeklyExamService.getAllCount();
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", total);
		jsonMap.put("rows", weeklyExamList);
		try {
			response.getWriter().print(JSON.toJSONString(jsonMap));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/showAllDataNearest")
	public void showAllDataNearest(HttpServletRequest request,
				HttpServletResponse response, Model model, 
				WeeklyExamShowOne wexam,int page,int rows) {
		List<WeeklyExamShowOne> weeklyExamList = this.weeklyExamService.getAllClassWeeklyExamNearest((page-1)*rows,rows);
		int total = this.weeklyExamService.getAllCount();
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", total);
		jsonMap.put("rows", weeklyExamList);
		try {
			response.getWriter().print(JSON.toJSONString(jsonMap));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}