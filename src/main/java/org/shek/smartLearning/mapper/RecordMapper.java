package org.shek.smartLearning.mapper;

import java.util.List;
import org.shek.smartLearning.pojo.Record;
import org.shek.smartLearning.pojo.RecordExample;

public interface RecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Record record);

    int insertSelective(Record record);

    List<Record> selectByExample(RecordExample example);

    Record selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);
}