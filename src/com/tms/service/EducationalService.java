package com.tms.service;

import java.util.List;

import com.tms.model.EducationalShowOne;

public interface EducationalService {
	public int getAllCount();
	//显示指定教务周数据
		public List<EducationalShowOne> getAllEducationalByWeek(int page, int rows, String weeklyyear, String weeklymonth,
				String weeklyday);
		
	//显示最新的教务数据（根据班级进行分组）
		public List<EducationalShowOne> getAllEducationalNearest(int page, int rows);
}
