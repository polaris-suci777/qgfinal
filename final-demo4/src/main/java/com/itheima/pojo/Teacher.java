package com.itheima.pojo;

/**
 * 品牌实体类
 */

public class Teacher {
    public Teacher(String subject, Integer id, String name, String introduction, String email, String qq, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.qq = qq;
        this.subject = subject;
        this.introduction = introduction;
    }

    private  String subject;
    private  Integer id;
    private String name;
    private String introduction;
    private String email;
    private String qq;
    private  String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Teacher() {
    }
    // toString方法，方便输出教师信息
    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}



