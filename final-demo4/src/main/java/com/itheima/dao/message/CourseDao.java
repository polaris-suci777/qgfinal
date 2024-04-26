package com.itheima.dao.message;

import com.itheima.pojo.Course;
import com.itheima.util.JDBCUtil;
import com.itheima.util.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {

    public Course createCourse(Course course) throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "INSERT INTO course (id, name, description,startdate,enddate,enrollmentlimit) VALUES (null,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, course.getName());
            stmt.setString(2, course.getDescription());
            stmt.setString(3, course.getStartdate());
            stmt.setString(4, course.getEnddate());
            stmt.setInt(5, course.getEnrollmentlimit());
            stmt.executeUpdate();
            // 假设插入成功，返回插入的教师对象（在实际应用中，您可能需要从数据库重新检索以获取完整或更新的数据）  
            return course;
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // 在发生异常时返回null  
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Course> SelectAll() throws SQLException {
        Connection conn;
        conn = DruidUtils.getConnection();
        String sql = "select * from course;";
        //3. 获取pstmt对象
        PreparedStatement stmt = conn.prepareStatement(sql);
        //4. 设置参数
        //5. 执行SQL
        ResultSet rs = stmt.executeQuery();
        //6. 处理结果 List<Brand> 封装Brand对象，装载List集合
        Course course;
        List<Course> courses = new ArrayList<>();
        while (rs.next()) {
            //获取数据
            int id = rs.getInt("id");
            String name= rs.getString("name");
            String description = rs.getString("description");
            String startdate = rs.getString("startdate");
            String enddate = rs.getString("enddate");
            int enrollmentlimit = rs.getInt("enrollmentlimit");
            //封装course对象
            course = new Course();
            course.setId(id);
            course.setName(name);
            course.setDescription(description);
            course.setStartdate(startdate);
            course.setEnddate(enddate);
            course.setEnrollmentlimit(enrollmentlimit);
            //装载集合
            courses.add(course);
        }
        return courses;
    }

    public List<Course> SelectAllByCourse_name(String course_name) throws SQLException {
        Connection conn;
        conn = DruidUtils.getConnection();
        String sql = "select * from course WHERE name = ?;";
        //3. 获取pstmt对象
        PreparedStatement stmt = conn.prepareStatement(sql);
        //4. 设置参数
        stmt.setString(1, course_name);
        //5. 执行SQL
        ResultSet rs = stmt.executeQuery();
        //6. 处理结果 List<Brand> 封装Brand对象，装载List集合
        Course course;
        List<Course> courses = new ArrayList<>();
        while (rs.next()) {
            //获取数据
            int id = rs.getInt("id");
            String name= rs.getString("name");
            String description = rs.getString("description");
            String startdate = rs.getString("startdate");
            String enddate = rs.getString("enddate");
            int enrollmentlimit = rs.getInt("enrollmentlimit");
            //封装course对象
            course = new Course();
            course.setId(id);
            course.setName(name);
            course.setDescription(description);
            course.setStartdate(startdate);
            course.setEnddate(enddate);
            course.setEnrollmentlimit(enrollmentlimit);
            //装载集合
            courses.add(course);
        }
        return courses;
    }
    public Course selectById(int id) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        Course course = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "SELECT * FROM course WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                course = new Course();
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                course.setDescription(rs.getString("description"));
                course.setStartdate(rs.getString("startdate"));
                course.setEnddate(rs.getString("enddate"));
                course.setEnrollmentlimit(rs.getInt("enrollmentlimit"));
                // ... 设置其他属性 ...  
            }
                rs.close();
                stmt.close();
                conn.close();;;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return course; // 如果没有找到，返回null

    }

    public Course selectByName(String name) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        Course course = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "SELECT * FROM course WHERE name = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            rs = stmt.executeQuery();
            if (rs.next()) {
                course = new Course();
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                course.setDescription(rs.getString("description"));
                course.setStartdate(rs.getString("startdate"));
                course.setEnddate(rs.getString("enddate"));
                course.setEnrollmentlimit(rs.getInt("enrollmentlimit"));
                // ... 设置其他属性 ...
            }
            rs.close();
            stmt.close();
            conn.close();;;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course; // 如果没有找到，返回null

    }
    public void update(Course course){
        Connection conn;
        try {
            conn = DruidUtils.getConnection();

        //2. 定义SQL
        String sql ="update course set name = ?,description = ?,startdate = ?,enddate = ?,enrollmentlimit=? where id = ?";
            //3. 获取stmt对象
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, course.getName());
            stmt.setString(2, course.getDescription());
            stmt.setString(3, course.getStartdate());
            stmt.setString(4, course.getEnddate());
            stmt.setInt(5, course.getEnrollmentlimit());
            stmt.setInt(6, course.getId());
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
            String sql ="delete from course where id = ? ";
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