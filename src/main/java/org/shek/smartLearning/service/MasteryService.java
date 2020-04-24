package org.shek.smartLearning.service;

import org.shek.smartLearning.mapper.MasteryMapper;
import org.shek.smartLearning.pojo.Mastery;

public interface MasteryService {
    /*根据知识点名称、用户ID查询*/
    Mastery findByKnowledge(String knowledge, Integer id);

    /*添加*/
    void add(Mastery mastery);

    /*更新*/
    void update(Mastery mastery);

}
