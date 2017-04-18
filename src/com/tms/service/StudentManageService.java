
package com.tms.service;

import java.util.List;

import com.tms.model.Student;

public interface StudentManageService {
	
	public Student getUserById(String studentId);
	
	public List<Student> getAllUser(int page,int row);
	
	public int getAllCount();
	
	public int updateByPrimaryKeySelective(Student student);
	
	public int InsertSelective(Student student);
	
	public int deleteByPrimaryKey(String id);
}
