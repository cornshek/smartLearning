package org.shek.smartLearning.service;

import org.shek.smartLearning.pojo.Test;

import java.util.List;

public interface TestService {
    void add(Test test);

    /*查询所有*/
    List<Test> list();
}
