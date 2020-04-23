package org.shek.smartLearning.pojo;

public class Theorem {
    private Integer id;

    private String name;

    private String content;

    private String confusion1;

    private String confusion2;

    private String confusion3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
}