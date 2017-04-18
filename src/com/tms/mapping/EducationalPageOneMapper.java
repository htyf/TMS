package com.tms.mapping;

import java.util.List;
import java.util.Map;

import com.tms.model.EducationalShowOne;


public interface EducationalPageOneMapper {
	
	//获取指定周的所有教务数据
	List<EducationalShowOne> getAllEducationByWeek(Map<String, Object> map);
	
	//获取默认最新的教务数据统计
	List<EducationalShowOne> getAllEducationNearest(Map<String, Integer> map);
	
	//获取所有周的教务数据
	List<EducationalShowOne> getAllEducation(Map<String, Integer> map);
	
	int getAllCount();

	

	
	
	
}
