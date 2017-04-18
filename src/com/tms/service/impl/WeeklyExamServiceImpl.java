package com.tms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tms.mapping.WeeklyExamShowClassScoreMapper;
import com.tms.mapping.WeeklyExamShowOneMapper;
import com.tms.model.WeeklyExamShowClassScore;
import com.tms.model.WeeklyExamShowOne;
import com.tms.model.WeeklyTime;
import com.tms.service.WeeklyExamService;


@Service("weeklyExamService")
public class WeeklyExamServiceImpl implements WeeklyExamService {
	@Resource
	private WeeklyExamShowOneMapper weeklyExamShowOneMapper;
	@Resource
	private WeeklyExamShowClassScoreMapper weeklyExamShowClassScoreMapper;
	@Override
	public WeeklyExamShowOne getWeeklyExamByClassId(int classId) {
		return null;
	}
	
	@Override
	public int getAllCount() {
		return weeklyExamShowOneMapper.getAllCount();
	}
	
	@Override
	public List<WeeklyExamShowOne> getAllClassWeeklyExamByWeek(int page, int rows,String weeklyyear, String weeklymonth,
			String weeklyday) {
		Map map = new HashMap();
		map.put("page", page);
		map.put("rows", rows);
		map.put("wyear", weeklyyear);
		map.put("wmonth", weeklymonth);
		map.put("wday", weeklyday);
		return weeklyExamShowOneMapper.getAllWeeklyExamByWeek(map);
	}

	@Override
	public List<WeeklyExamShowOne> getAllClassWeeklyExamNearest(int page, int rows) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("page", page);
		map.put("rows", rows);
		return this.weeklyExamShowOneMapper.getAllWeeklyExamNearest(map);
	}

	@Override
	public List<WeeklyExamShowOne> getAllClassStudentWeekScore(int page, int rows, String classname, String weeklyyear,
			String weeklymonth, String weeklyday) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("page", page);
		map.put("rows", rows);
		map.put("classname", classname);
		map.put("wyear", weeklyyear);
		map.put("wmonth", weeklymonth);
		map.put("wday", weeklyday);
//		return weeklyExamShowOneMapper.getAllWeeklyExamByWeek(map);
		return this.weeklyExamShowClassScoreMapper.getAllStudentWeekScore(map);
		
		
	}

	
	

}
