package com.itheima.dao;
import com.itheima.pojo.Enrollment;
import com.itheima.util.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectCourseDao {

    public List<Enrollment> selectall() throws SQLException {
        Connection conn;
        conn = DruidUtils.getConnection();
        String sql = "select * from enrollments;";
        //3. 获取stmt对象
        PreparedStatement stmt = conn.prepareStatement(sql);
        //4. 设置参数
        //5. 执行SQL
        ResultSet rs = stmt.executeQuery();
        //6. 处理结果 List<Brand> 封装Brand对象，装载List集合
        Enrollment enrollment;
        List<Enrollment> enrollments = new ArrayList<>();
        while (rs.next()) {
            //获取数据
            int id = rs.getInt("id");
            String course_name= rs.getString("course_name");
            String student_name= rs.getString("student_name");
            //封装course对象
            enrollment = new Enrollment();
            enrollment.setId(id);
            enrollment.setCourse_name(course_name);
            enrollment.setStudent_name(student_name);
            //装载集合
            enrollments.add(enrollment);
        }
        return enrollments;
    }

    public Enrollment selectById(int id) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        Enrollment enrollment = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "SELECT * FROM enrollments WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                enrollment = new Enrollment();
                enrollment.setId(rs.getInt("id"));
                enrollment.setCourse_name(rs.getString("name"));
                enrollment.setStudent_name(rs.getString("description"));
                // ... 设置其他属性 ...
            }
            rs.close();
            stmt.close();
            conn.close();;;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollment; // 如果没有找到，返回null

    }
    public void addEnrollment(String course_name,String student_name){
        Connection conn;
        PreparedStatement stmt;
        try {
            conn = DruidUtils.getConnection();
            String sql = "INSERT INTO enrollments (id,course_name,student_name) VALUES (null,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, course_name);
            stmt.setString(2, student_name);
            stmt.executeUpdate();
            stmt.close();
            conn.close();;;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Enrollment> showStudent(String course_name) throws SQLException {
        Connection conn;
        conn = DruidUtils.getConnection();
        String sql = "select * from enrollments WHERE course_name = ?;";
        //3. 获取stmt对象
        PreparedStatement stmt = conn.prepareStatement(sql);
        //4. 设置参数
        stmt.setString(1, course_name);
        //5. 执行SQL
        ResultSet rs = stmt.executeQuery();
        //6. 处理结果 List<Brand> 封装Brand对象，装载List集合
        Enrollment enrollment;
        List<Enrollment> enrollments = new ArrayList<>();
        while (rs.next()) {
            //获取数据
            int id = rs.getInt("id");
            String student_name= rs.getString("student_name");
            //封装course对象
            enrollment = new Enrollment();
            enrollment.setId(id);
            enrollment.setCourse_name(course_name);
            enrollment.setStudent_name(student_name);
            //装载集合
            enrollments.add(enrollment);
        }
        return enrollments;
    }

    public List<Enrollment> showSelectCourse(String student_name) throws SQLException {
        Connection conn;
        conn = DruidUtils.getConnection();
        String sql = "select * from enrollments WHERE student_name = ?;";
        //3. 获取stmt对象
        PreparedStatement stmt = conn.prepareStatement(sql);
        //4. 设置参数
        stmt.setString(1, student_name);
        //5. 执行SQL
        ResultSet rs = stmt.executeQuery();
        //6. 处理结果 List<Brand> 封装Brand对象，装载List集合
        Enrollment enrollment;
        List<Enrollment> enrollments = new ArrayList<>();
        while (rs.next()) {
            //获取数据
            int id = rs.getInt("id");
            String course_name= rs.getString("course_name");
            //封装course对象
            enrollment = new Enrollment();
            enrollment.setId(id);
            enrollment.setCourse_name(course_name);
            enrollment.setStudent_name(student_name);
            //装载集合
            enrollments.add(enrollment);
        }
        return enrollments;
    }
    public List<String> enrollmentStudents(String course_name) throws SQLException {
        Connection conn;
        conn = DruidUtils.getConnection();
        String sql = "select * from enrollments WHERE course_name = ?;";
        //3. 获取stmt对象
        PreparedStatement stmt = conn.prepareStatement(sql);
        //4. 设置参数
        stmt.setString(1, course_name);
        //5. 执行SQL
        ResultSet rs = stmt.executeQuery();
        //6. 处理结果 List<Brand> 封装Brand对象，装载List集合
        List<String> enrollmentStudents = new ArrayList<>();
        while (rs.next()) {
            //获取数据
            String student_name= rs.getString("student_name");

            //装载集合
            enrollmentStudents.add(student_name);
        }
        return enrollmentStudents;
    }
    public String selectByStudent_name(String student_name) throws SQLException {
        Connection conn;
        conn = DruidUtils.getConnection();
        String sql = "select * from enrollments WHERE student_name = ?;";
        //3. 获取stmt对象
        PreparedStatement stmt = conn.prepareStatement(sql);
        //4. 设置参数
        stmt.setString(1, student_name);
        //5. 执行SQL
        ResultSet rs = stmt.executeQuery();
        //6. 处理结果 List<Brand> 封装Brand对象，装载List集合
        List<String> enrollmentStudents = new ArrayList<>();
        String course_name = null;
        while (rs.next()) {
            //获取数据
            course_name = rs.getString("course_name");

        }
        return course_name;
    }

    public void delete(int id){
        Connection conn;
        try {
            conn = DruidUtils.getConnection();
            //2. 定义SQL
            String sql ="delete from enrollments where id = ? ";
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
