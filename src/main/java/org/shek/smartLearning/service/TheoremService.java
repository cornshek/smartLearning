package org.shek.smartLearning.service;

import org.shek.smartLearning.pojo.Theorem;

import java.util.List;

public interface TheoremService {
    void add(Theorem theorem);

    /*查询所有*/
    List<Theorem> list();

    /*根据name查询*/
    List<Theorem> findByName(String name);

    /*根据参数number随机选择 权重：masteryValue*/
    List<Theorem> listRandomWithMastery(Integer number);
}
