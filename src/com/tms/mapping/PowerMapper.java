
package com.tms.mapping;


import java.util.List;
import java.util.Map;

import com.tms.model.Power;


public interface PowerMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Power record);

	int insertSelective(Power record);

	int getAllCount();
	
	Power selectByPrimaryKey(Integer id);

	List<Power> getAllPower(Map<String,Integer> map);

	int updateByPrimaryKeySelective(Power power);

	int updateByPrimaryKey(Power record);
}