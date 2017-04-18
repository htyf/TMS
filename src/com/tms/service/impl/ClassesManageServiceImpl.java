package com.tms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tms.mapping.ClassesManageMapper;
import com.tms.model.Classes;
import com.tms.service.ClassesManageService;

@Service("classManageService")
public class ClassesManageServiceImpl implements ClassesManageService{
    @Resource
    private ClassesManageMapper classesManageMapper;
	@Override
	public List<Classes> getAllClasses(int page, int rows) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("page", page);
		map.put("rows", rows);
		return this.classesManageMapper.getAllClasses(map);
	}
	@Override
	public int getAllCount() {
		return this.classesManageMapper.getAllCount();
	}
	@Override
	public String searchTid(String tname) {
		
		return this.classesManageMapper.searchTid(tname);
	}
	@Override
	public String searchStuId(String stuName) {
		return this.classesManageMapper.searchStuId(stuName);
	}
	@Override
	public void updateForClass(Classes classes) {
		this.classesManageMapper.updateForClass(classes);
		
	}
	@Override
	public int searchIsContainStu(String classId) {
		return this.classesManageMapper.searchIsContainStu(classId);
	}
	@Override
	public int deleteForClass(String id) {
		
		return this.classesManageMapper.deleteForClassById(id);
	}
	@Override
	public int addOneClass(Classes classes) {
		
		return this.classesManageMapper.addOneClass(classes);
	}
	@Override
	public String searchJobDireId(String jobTeaName) {
		return this.classesManageMapper.searchJobDireId(jobTeaName);
	}
	@Override
	public void updateTeachMethods(Classes classes) {
		this.classesManageMapper.updateTeachMethods(classes);
		
	}
	@Override
	public String searchClassManagerId(String classmanagername) {
		
		return this.classesManageMapper.searchClassManagerId(classmanagername);
	}
	@Override
	public String searchTeachScheduleId(String coursecontent) {
		// TODO Auto-generated method stub
		return this.classesManageMapper.searchTeachScheduleId(coursecontent);
	}
	

}
