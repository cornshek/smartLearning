package org.shek.smartLearning.mapper;

import java.util.List;
import org.shek.smartLearning.pojo.EnWord;
import org.shek.smartLearning.pojo.EnWordExample;

public interface EnWordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnWord record);

    int insertSelective(EnWord record);

    List<EnWord> selectByExample(EnWordExample example);

    EnWord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnWord record);

    int updateByPrimaryKey(EnWord record);
}