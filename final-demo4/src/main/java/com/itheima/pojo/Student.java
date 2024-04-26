package com.itheima.pojo;

/**
 * 品牌实体类
 */

public class Student {
    private  Integer id;
    private String name;
    private String password;
    private String studentnumber;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentnumber() {
        return studentnumber;
    }

    public void setStudentnumber(String studentnumber) {
        this.studentnumber = studentnumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String grade;

    private String introduction;

    private String sex;


    public Student() {
    }
    // toString方法，方便输出教师信息
    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", studentnumber='" + studentnumber + '\'' +
                ", grade='" + grade + '\'' +
                "id=" + id +
                ", introduction='" + introduction + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}



