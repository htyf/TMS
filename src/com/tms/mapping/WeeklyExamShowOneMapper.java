package com.tms.mapping;

import java.util.List;
import java.util.Map;

import com.tms.model.WeeklyExamShowOne;

public interface WeeklyExamShowOneMapper {
	
	
	
	List<WeeklyExamShowOne> getAllWeeklyExamByWeek(Map<String, Object> map);
	
	List<WeeklyExamShowOne> getAllWeeklyExamNearest(Map<String, Integer> map);
	
	List<WeeklyExamShowOne> getAllWeeklyExam(Map<String, Integer> map);
	
	int getAllCount();

	

	
	
	
}
