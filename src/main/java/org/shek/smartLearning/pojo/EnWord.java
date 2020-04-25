package org.shek.smartLearning.pojo;

public class EnWord implements Comparable<EnWord>{
    private Integer id;

    private String word;

    private String translation;

    /*非数据库字段*/
    private int masteryValue;

    public int getMasteryValue() {
        return masteryValue;
    }

    public void setMasteryValue(int masteryValue) {
        this.masteryValue = masteryValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word == null ? null : word.trim();
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation == null ? null : translation.trim();
    }

    @Override
    public int compareTo(EnWord o) {
        /*升序*/
        return this.getMasteryValue() - o.getMasteryValue();
    }
}