package com.tms.service;

import java.util.List;

import com.tms.model.Classes;

public interface ClassesManageService {

	public List<Classes> getAllClasses(int page, int rows);

	public int getAllCount();

	public String searchTid(String tname);
	
	public String searchStuId(String stuName);

	public void updateForClass(Classes classes);

	public int searchIsContainStu(String classId);

	public int deleteForClass(String id);

	public int addOneClass(Classes classes);

	public String searchJobDireId(String jobTeaName);

	public void updateTeachMethods(Classes classes);

	public String searchClassManagerId(String classmanagername);

	public String searchTeachScheduleId(String coursecontent);


	

}
