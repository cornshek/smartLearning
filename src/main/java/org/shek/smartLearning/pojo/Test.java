package org.shek.smartLearning.pojo;

public class Test {
    private Integer id;

    private String question;

    private String answer;

    private String confusion1;

    private String confusion2;

    private String confusion3;

    private Integer recordId;

    private String knowledge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
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

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge == null ? null : knowledge.trim();
    }
}