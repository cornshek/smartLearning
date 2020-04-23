package org.shek.smartLearning.service;

import org.shek.smartLearning.pojo.EnWord;

import java.util.List;

public interface EnWordService {
    List<EnWord> listRandom(Integer number);

    List<EnWord> listAnswers(EnWord answer);

}
