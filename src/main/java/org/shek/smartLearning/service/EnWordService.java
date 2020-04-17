package org.shek.smartLearning.service;

import org.shek.smartLearning.pojo.EnWords;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EnWordService {
    List<EnWords> list();
}
