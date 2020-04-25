package org.shek.smartLearning.service;

import org.shek.smartLearning.pojo.Theorem;

import java.util.List;

public interface TheoremService {
    void add(Theorem theorem);

    /*根据参数number随机选择 权重：masteryValue*/
    List<Theorem> listRandomWithMastery(Integer number);
}
