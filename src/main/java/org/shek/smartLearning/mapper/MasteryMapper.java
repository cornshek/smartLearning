package org.shek.smartLearning.mapper;

import java.util.List;
import org.shek.smartLearning.pojo.Mastery;
import org.shek.smartLearning.pojo.MasteryExample;

public interface MasteryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Mastery record);

    int insertSelective(Mastery record);

    List<Mastery> selectByExample(MasteryExample example);

    Mastery selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Mastery record);

    int updateByPrimaryKey(Mastery record);
}