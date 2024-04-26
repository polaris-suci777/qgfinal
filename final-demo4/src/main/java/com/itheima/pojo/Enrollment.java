package com.itheima.pojo;

public class Enrollment {
    public Enrollment(Integer id, String course_name, String student_name) {
        this.id = id;
        this.course_name = course_name;
        this.student_name = student_name;
    }

    private  Integer id;
    private String course_name;
    private String student_name;

    public Enrollment() {

    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", course_name='" + course_name + '\'' +
                ", student_name='" + student_name + '\'' +
                '}';
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

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }


}
