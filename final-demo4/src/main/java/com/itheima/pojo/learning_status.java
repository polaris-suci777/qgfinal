package com.itheima.pojo;

public class Learning_status {
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

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Learning_status() {
    }

    @Override
    public String toString() {
        return "learning_status{" +
                "id=" + id +
                ", course_name='" + course_name + '\'' +
                ", student_name='" + student_name + '\'' +
                ", chapter='" + chapter + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    private Integer id;
    private String course_name;
    private String student_name;
    private String chapter;
    private String status;
}
