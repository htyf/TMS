package com.tms.mapping;

import com.tms.model.Classes;

public interface ClassesMapper {
    int deleteByPrimaryKey(String classid);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(String classid);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
}