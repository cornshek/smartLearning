package org.shek.smartLearning.service;

import org.shek.smartLearning.pojo.EnWord;

import java.util.List;

public interface EnWordService {
    List<EnWord> listRandomWithMastery(Integer number);

    /*查询所有单词*/
    List<EnWord> list();

    /*根据word查询*/
    List<EnWord> findByWord(String word);

    List<EnWord> listAnswers(EnWord answer);

}
