package org.shek.smartLearning.service;

import org.shek.smartLearning.pojo.Record;

import java.util.List;

public interface RecordService {
    Record check(Integer id);

    void add(Record record);
}
