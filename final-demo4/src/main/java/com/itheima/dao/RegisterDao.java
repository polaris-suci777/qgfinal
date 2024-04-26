package com.itheima.dao;

import com.itheima.pojo.Manager;
import com.itheima.pojo.Student;
import com.itheima.pojo.Teacher;
import com.itheima.util.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDao {
    public Student registerStudent(Student student) throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "INSERT INTO student (id, name, password,studentnumber,grade,introduction,sex) VALUES (null,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getPassword());
            stmt.setString(3, student.getStudentnumber());
            stmt.setString(4, student.getGrade());
            stmt.setString(5, student.getIntroduction());
            stmt.setString(6, student.getSex());
            stmt.executeUpdate();
            // 假设插入成功，返回插入的教师对象（在实际应用中，您可能需要从数据库重新检索以获取完整或更新的数据）
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // 在发生异常时返回null
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();;;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public Manager registerManager(Manager manager) throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "INSERT INTO manager (id, name, password) VALUES (null,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, manager.getName());
            stmt.setString(2, manager.getPassword());
            stmt.executeUpdate();
            // 假设插入成功，返回插入的教师对象（在实际应用中，您可能需要从数据库重新检索以获取完整或更新的数据）
            return manager;
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // 在发生异常时返回null
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();;;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public Teacher registerTeacher(Teacher teacher) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "INSERT INTO teacher (id, name, password,email,qq,subject,introduction) VALUES (null,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, teacher.getName());
            stmt.setString(2, teacher.getPassword());
            stmt.setString(3, teacher.getEmail());
            stmt.setString(4, teacher.getQq());
            stmt.setString(5, teacher.getSubject());
            stmt.setString(6, teacher.getIntroduction());
            stmt.executeUpdate();
            // 假设插入成功，返回插入的教师对象（在实际应用中，您可能需要从数据库重新检索以获取完整或更新的数据）
            return teacher;
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // 在发生异常时返回null
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();;;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public Teacher selectByTeacherName(String teacher_name) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Teacher teacher = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "SELECT * FROM teacher WHERE name = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, teacher_name);
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
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();;;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher; // 如果没有找到，返回null

    }
    public Student selectByStudentName(String student_name) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        Student student = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "SELECT * FROM student WHERE name = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,student_name);
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
            e.printStackTrace();
        }
        return student; // 如果没有找到，返回null

    }
    public Manager selectByManagerName(String manager_name) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        Manager manager = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "SELECT * FROM manager WHERE name = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,manager_name);
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
            e.printStackTrace();
        }
        return manager; // 如果没有找到，返回null

    }

}
