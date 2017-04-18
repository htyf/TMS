package com.tms.mapping;

import java.util.List;
import java.util.Map;

import com.tms.model.WeeklyExamShowOne;

public interface WeeklyExamShowClassScoreMapper {
	
	List<WeeklyExamShowOne> getAllStudentWeekScore(Map<String, Object> map);
	

	

}
