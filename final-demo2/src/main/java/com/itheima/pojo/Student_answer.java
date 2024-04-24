package com.itheima.pojo;

public class Student_answer {
    public Student_answer() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;
    private String course_name;
    private String student_name;
    private String answer;
    private String is_correct;
    private String grade;

    @Override
    public String toString() {
        return "Student_answer{" +
                "course_name='" + course_name + '\'' +
                ", student_name='" + student_name + '\'' +
                ", answer='" + answer + '\'' +
                ", is_correct='" + is_correct + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }



    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getIs_correct() {
        return is_correct;
    }

    public void setIs_correct(String is_correct) {
        this.is_correct = is_correct;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }



}
