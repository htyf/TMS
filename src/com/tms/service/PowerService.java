
package com.tms.service;

import java.util.List;

import com.tms.model.Power;



public interface PowerService {
	public Power getPowerById(int powerId);
	
	public List<Power> getAllPower(int page,int row);
	
	public int getAllCount();
	
	public int updateByPrimaryKeySelective(Power power);
	
	public int InsertSelective(Power power);
	
	public int deleteByPrimaryKey(int id);
}
