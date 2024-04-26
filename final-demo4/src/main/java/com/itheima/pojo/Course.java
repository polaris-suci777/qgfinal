package com.itheima.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 品牌实体类
 */

public class Course {
    public Course(Integer id, String name, String description, String startdate, String enddate, Integer enrollmentlimit) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startdate = startdate;
        this.enddate = enddate;
        this.enrollmentlimit = enrollmentlimit;
        this.enrolledStudents = new ArrayList<>();
        Map<String, String> enrollments;
//        this.questions = new ArrayList<>();
    }


    private List<String> enrolledStudents;
//    private List<Question> questions;
    private  Integer id;
    private String name;
    private String description;
    private String startdate;
    private String enddate;

    public Integer getEnrollmentlimit() {
        return enrollmentlimit;
    }

    public void setEnrollmentlimit(Integer enrollmentlimit) {
        this.enrollmentlimit = enrollmentlimit;
    }

    private  Integer enrollmentlimit;




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
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }


    public List<String> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<String> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

//    public boolean enrollStudent(String student_name) {
//        if (enrolledStudents.size() < enrollmentlimit) {
//            enrolledStudents.add(student_name);
//            return true; // 选课成功
//        } else {
//            return false; // 选课失败，课程容量已满
//        }
//    }
    // 尝试为学生选课，如果课程容量未满，返回true；否则返回false




    public Course() {
    }
    // toString方法，方便输出教师信息
    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startdate='" + startdate + '\'' +
                ", endate='" + enddate + '\'' +
                "id=" + id +
                ", enrollmentlimit='" + enrollmentlimit + '\'' +
                '}';
    }
}



