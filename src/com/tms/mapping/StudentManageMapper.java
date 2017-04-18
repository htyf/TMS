
package com.tms.mapping;


import java.util.List;
import java.util.Map;

import com.tms.model.Student;


public interface StudentManageMapper {
	int deleteByPrimaryKey(String id);

	int insert(Student record);

	int insertSelective(Student record);

	int getAllCount();
	Student selectByPrimaryKey(String id);

	List<Student> getAllStudent(Map<String,Integer> map);

	int updateByPrimaryKeySelective(Student record);

	int updateByPrimaryKey(Student record);
}