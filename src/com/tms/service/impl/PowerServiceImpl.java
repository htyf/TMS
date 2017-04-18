
package com.tms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tms.mapping.PowerMapper;
import com.tms.model.Power;
import com.tms.service.PowerService;


@Service("powerService")  
public class PowerServiceImpl implements PowerService {
	 @Resource
	    private PowerMapper powerMapper;  
	@Override
	public Power getPowerById(int powerId) {
		 return this.powerMapper.selectByPrimaryKey(powerId);
	}
	@Override
	public List<Power> getAllPower(int page,int rows) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("page", page);
		map.put("rows", rows);
		return this.powerMapper.getAllPower(map);
	}
	@Override
	public int updateByPrimaryKeySelective(Power power) {
		return this.powerMapper.updateByPrimaryKeySelective(power);
	}
	@Override
	public int InsertSelective(Power power) {
		return this.powerMapper.insertSelective(power);
	}
	@Override
	public int deleteByPrimaryKey(int id) {
		return this.powerMapper.deleteByPrimaryKey(id);
	}
	@Override
	public int getAllCount() {
		return this.powerMapper.getAllCount();
	}
	

}
