package org.shek.smartLearning.mapper;

import java.util.List;
import org.shek.smartLearning.pojo.Theorem;
import org.shek.smartLearning.pojo.TheoremExample;

public interface TheoremMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Theorem record);

    int insertSelective(Theorem record);

    List<Theorem> selectByExample(TheoremExample example);

    Theorem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Theorem record);

    int updateByPrimaryKey(Theorem record);
}