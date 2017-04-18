package com.tms.mapping;

import com.tms.model.WeeklyTime;

public interface WeeklyTimeMapper {
    int deleteByPrimaryKey(String weeklytimeid);

    int insert(WeeklyTime record);

    int insertSelective(WeeklyTime record);

    WeeklyTime selectByPrimaryKey(String weeklytimeid);

    int updateByPrimaryKeySelective(WeeklyTime record);

    int updateByPrimaryKey(WeeklyTime record);
}