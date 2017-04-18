package com.tms.mapping;

import java.util.List;
import java.util.Map;

import com.tms.model.Classes;

public interface ClassesManageMapper {

	List<Classes> getAllClasses(Map<String, Integer> map);

	int getAllCount();

	String searchTid(String tname);
	
	String searchStuId(String stuName);

	void updateForClass(Classes classes);

	int searchIsContainStu(String classId);

	int deleteForClassById(String id);

	int addOneClass(Classes classes);

	String searchJobDireId(String jobTeaName);

	void updateTeachMethods(Classes classes);

	String searchClassManagerId(String classmanagername);

	String searchTeachScheduleId(String coursecontent);

	

}
