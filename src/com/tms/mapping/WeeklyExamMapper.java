package com.tms.mapping;

import com.tms.model.WeeklyExam;

public interface WeeklyExamMapper {
    int deleteByPrimaryKey(String weekliexamid);

    int insert(WeeklyExam record);

    int insertSelective(WeeklyExam record);

    WeeklyExam selectByPrimaryKey(String weekliexamid);

    int updateByPrimaryKeySelective(WeeklyExam record);

    int updateByPrimaryKey(WeeklyExam record);
}