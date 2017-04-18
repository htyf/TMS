
package com.tms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;




import org.springframework.stereotype.Service;

import com.tms.mapping.StudentManageMapper;
import com.tms.mapping.Sys_UserMapper;
import com.tms.model.Student;
import com.tms.model.Sys_User;
import com.tms.service.StudentManageService;
import com.tms.service.Sys_UserService;


@Service("studentManageService")  
public class StudentManageServiceImpl implements StudentManageService {
	 @Resource
	    private StudentManageMapper studentManageMapper;  
	@Override
	public Student getUserById(String userId) {
		 return this.studentManageMapper.selectByPrimaryKey(userId);
	}
	@Override
	public List<Student> getAllUser(int page,int rows) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("page", page);
		map.put("rows", rows);
		return this.studentManageMapper.getAllStudent(map);
	}
	@Override
	public int updateByPrimaryKeySelective(Student student) {
		return this.studentManageMapper.updateByPrimaryKeySelective(student);
	}
	@Override
	public int InsertSelective(Student student) {
		return this.studentManageMapper.insertSelective(student);
	}
	@Override
	public int deleteByPrimaryKey(String id) {
		return this.studentManageMapper.deleteByPrimaryKey(id);
	}
	@Override
	public int getAllCount() {
		return this.studentManageMapper.getAllCount();
	}
	

}
