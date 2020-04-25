package org.shek.smartLearning.pojo;

public class Poetry implements Comparable<Poetry>{
    private Integer id;

    private String blank;

    private String fill;

    private String confusion1;

    private String confusion2;

    private String confusion3;

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

    public String getBlank() {
        return blank;
    }

    public void setBlank(String blank) {
        this.blank = blank == null ? null : blank.trim();
    }

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill == null ? null : fill.trim();
    }

    public String getConfusion1() {
        return confusion1;
    }

    public void setConfusion1(String confusion1) {
        this.confusion1 = confusion1 == null ? null : confusion1.trim();
    }

    public String getConfusion2() {
        return confusion2;
    }

    public void setConfusion2(String confusion2) {
        this.confusion2 = confusion2 == null ? null : confusion2.trim();
    }

    public String getConfusion3() {
        return confusion3;
    }

    public void setConfusion3(String confusion3) {
        this.confusion3 = confusion3 == null ? null : confusion3.trim();
    }

    @Override
    public int compareTo(Poetry o) {
        /*升序*/
        return this.getMasteryValue() - o.getMasteryValue();
    }
}