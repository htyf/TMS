package com.tms.service;

import java.util.List;

import com.tms.model.WeeklyExamShowOne;
import com.tms.model.WeeklyTime;

public interface WeeklyExamService{
	
	public WeeklyExamShowOne getWeeklyExamByClassId(int classId);
	
	public int getAllCount();
	
	public List<WeeklyExamShowOne> getAllClassWeeklyExamByWeek(int page, int rows, String weeklyyear, String weeklymonth,
			String weeklyday);

	public List<WeeklyExamShowOne> getAllClassWeeklyExamNearest(int page, int rows);

	public List<WeeklyExamShowOne> getAllClassStudentWeekScore(int page, int rows, String classname, String weeklyyear,
			String weeklymonth, String weeklyday);

	
	

	

	
	
	
}
