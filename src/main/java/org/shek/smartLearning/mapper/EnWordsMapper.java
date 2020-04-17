package org.shek.smartLearning.mapper;

import java.util.List;
import org.shek.smartLearning.pojo.EnWords;
import org.shek.smartLearning.pojo.EnWordsExample;

public interface EnWordsMapper {
    int insert(EnWords record);

    int insertSelective(EnWords record);

    List<EnWords> selectByExample(EnWordsExample example);
}