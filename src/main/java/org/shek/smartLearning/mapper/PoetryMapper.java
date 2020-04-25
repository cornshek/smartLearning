package org.shek.smartLearning.mapper;

import java.util.List;
import org.shek.smartLearning.pojo.Poetry;
import org.shek.smartLearning.pojo.PoetryExample;

public interface PoetryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Poetry record);

    int insertSelective(Poetry record);

    List<Poetry> selectByExample(PoetryExample example);

    Poetry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Poetry record);

    int updateByPrimaryKey(Poetry record);
}