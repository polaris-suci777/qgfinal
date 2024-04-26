package com.itheima.dao.message;
import com.itheima.pojo.Student;
import com.itheima.util.DruidUtils;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public Student createStudent(Student student) throws Exception{
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

    public List<Student> SelectAll() throws SQLException {
        Connection conn;
        conn = DruidUtils.getConnection();
        String sql = "select * from student;";
        //3. 获取stmt对象
        PreparedStatement stmt = conn.prepareStatement(sql);
        //4. 设置参数
        //5. 执行SQL
        ResultSet rs = stmt.executeQuery();
        //6. 处理结果 List<Brand> 封装Brand对象，装载List集合
        Student student;
        List<Student> students = new ArrayList<>();
        while (rs.next()) {
            //获取数据
            int id = rs.getInt("id");
            String name= rs.getString("name");
            String password = rs.getString("password");
            String studentnumber = rs.getString("studentnumber");
            String grade = rs.getString("grade");
            String introduction = rs.getString("introduction");
            String sex = rs.getString("sex");
            //封装course对象
            student = new Student();
            student.setId(id);
            student.setName(name);
            student.setPassword(password);
            student.setStudentnumber(studentnumber);
            student.setGrade(grade);
            student.setIntroduction(introduction);
            student.setSex(sex);
            //装载集合
            students.add(student);
        }
        return students;
    }
    public Student selectById(int id) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        Student student = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "SELECT * FROM student WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
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
    public Student selectBynName(String name) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        Student student = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "SELECT * FROM student WHERE name = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
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
    public void update(Student student){
        Connection conn;
        try {
            conn = DruidUtils.getConnection();
        //2. 定义SQL
        String sql ="update student set name = ?,password = ?,studentnumber = ?,grade = ?,introduction=?,sex=? where id = ?";
            //3. 获取stmt对象
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getPassword());
            stmt.setString(3, student.getStudentnumber());
            stmt.setString(4, student.getGrade());
            stmt.setString(5, student.getIntroduction());
            stmt.setString(6, student.getSex());
            stmt.setInt(7, student.getId());
            stmt.executeUpdate();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();;;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(int id){
        Connection conn;
        try {
            conn = DruidUtils.getConnection();
            //2. 定义SQL
            String sql ="delete from student where id = ? ";
            //3. 获取stmt对象
            PreparedStatement stmt = conn.prepareStatement(sql);
            //4.设置参数
            stmt.setInt(1,id);
            stmt.executeUpdate();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();;;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}