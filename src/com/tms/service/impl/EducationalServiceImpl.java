package com.tms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tms.mapping.EducationalPageOneMapper;
import com.tms.model.EducationalShowOne;
import com.tms.service.EducationalService;
@Service("educationalService")
public class EducationalServiceImpl implements EducationalService{

	@Resource
	private EducationalPageOneMapper educationalPageOneMapper;
	
	
	@Override
	public int getAllCount() {
		return 0;
	}

	@Override
	public List<EducationalShowOne> getAllEducationalByWeek(int page, int rows, String weeklyyear, String weeklymonth,
			String weeklyday) {
		return null;
	}

	@Override
	public List<EducationalShowOne> getAllEducationalNearest(int page, int rows) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("page", page);
		map.put("rows", rows);
		return educationalPageOneMapper.getAllEducationNearest(map);
	}

	
}
