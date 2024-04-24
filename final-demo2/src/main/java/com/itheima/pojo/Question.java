package com.itheima.pojo;

public class Question {
    public Question() {

    }
    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", course_name='" + course_name + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", choicA='" + choicA + '\'' +
                ", choiceB='" + choiceB + '\'' +
                ", choiceC='" + choiceC + '\'' +
                ", choiceD='" + choiceD + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    private Integer id;
    private String course_name;
    private String type;
    private String content;
    private  String choicA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String answer;

    public Question(Integer id, String course_name, String type, String content, String choicA, String choiceB, String choiceC, String choiceD, String answer) {
        this.id = id;
        this.course_name = course_name;
        this.type = type;
        this.content = content;
        this.choicA = choicA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
        this.answer = answer;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getChoicA() {
        return choicA;
    }

    public void setChoicA(String choicA) {
        this.choicA = choicA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public void setChoiceB(String choiceB) {
        this.choiceB = choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public void setChoiceC(String choiceC) {
        this.choiceC = choiceC;
    }

    public String getChoiceD() {
        return choiceD;
    }

    public void setChoiceD(String choiceD) {
        this.choiceD = choiceD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
