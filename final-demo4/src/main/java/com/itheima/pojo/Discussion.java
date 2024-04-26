package com.itheima.pojo;

public class Discussion {
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

    public String getStudent_discussion() {
        return student_discussion;
    }

    public void setStudent_discussion(String student_discussion) {
        this.student_discussion = student_discussion;
    }

    public String getTeacher_discussion() {
        return teacher_discussion;
    }

    public void setTeacher_discussion(String teacher_discussion) {
        this.teacher_discussion = teacher_discussion;
    }

    @Override
    public String toString() {
        return "Discussion{" +
                "id=" + id +
                ", course_name='" + course_name + '\'' +
                ", student_discussion='" + student_discussion + '\'' +
                ", teacher_discussion='" + teacher_discussion + '\'' +
                '}';
    }

    public Discussion() {
    }

    private  Integer id;
    private String course_name;
    private String student_discussion;
    private String teacher_discussion;
}
