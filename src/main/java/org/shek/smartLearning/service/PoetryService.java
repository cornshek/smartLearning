package org.shek.smartLearning.service;

import org.shek.smartLearning.pojo.Poetry;

import java.util.List;

public interface PoetryService {

    void add(Poetry poetry);

    /*查询所有poetry*/
    List<Poetry> list();

    /*根据blank查询*/
    List<Poetry> findByBlank(String blank);

    /*根据参数number随机选择 权重：masteryValue*/
    List<Poetry> listRandomWithMastery(Integer number);
}
