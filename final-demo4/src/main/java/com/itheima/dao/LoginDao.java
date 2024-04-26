package com.itheima.dao;
import com.itheima.pojo.Manager;
import com.itheima.pojo.Student;
import com.itheima.pojo.Teacher;
import com.itheima.util.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    public Teacher teacherSelect(String name, String password) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        Teacher teacher = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "select * from teacher where name = ? and password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if (rs.next()) {
                teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setName(rs.getString("name"));
                teacher.setPassword(rs.getString("password"));
                teacher.setEmail(rs.getString("email"));
                teacher.setQq(rs.getString("qq"));
                teacher.setSubject(rs.getString("subject"));
                teacher.setIntroduction(rs.getString("introduction"));
                // ... 设置其他属性 ...
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teacher;
    }

    public Student studentSelect(String name, String password) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        Student student = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "select * from student where name = ? and password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setPassword(rs.getString("password"));
                student.setStudentnumber(rs.getString("studentnumber"));
                student.setGrade(rs.getString("grade"));
                student.setIntroduction(rs.getString("introduction"));
                student.setSex(rs.getString("sex"));
                // ... 设置其他属性 ...
            }
            rs.close();
            stmt.close();
            conn.close();;;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }
    public Manager managerSelect(String name, String password) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        Manager manager = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "select * from manager where name = ? and password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if (rs.next()) {
                manager = new Manager();
                manager.setId(rs.getInt("id"));
                manager.setName(rs.getString("name"));
                manager.setPassword(rs.getString("password"));
                // ... 设置其他属性 ...
            }
            rs.close();
            stmt.close();
            conn.close();;;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return manager;
    }
}