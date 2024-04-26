package com.itheima.dao;

import com.itheima.pojo.Course;
import com.itheima.pojo.Learning_status;
import com.itheima.util.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Learning_statusDao {
    public Learning_status createLearning_status(Learning_status learning_status) throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "INSERT INTO learning_status (id, course_name, student_name,chapter,status) VALUES (null,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, learning_status.getCourse_name());
            stmt.setString(2, learning_status.getStudent_name());
            stmt.setString(3, learning_status.getChapter());
            stmt.setString(4, learning_status.getStatus());
            stmt.executeUpdate();
            // 假设插入成功，返回插入的教师对象（在实际应用中，您可能需要从数据库重新检索以获取完整或更新的数据）
            return learning_status;
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
    public List<Learning_status> SelectAll() throws SQLException {
        Connection conn;
        conn = DruidUtils.getConnection();
        String sql = "select * from learning_status;";
        //3. 获取pstmt对象
        PreparedStatement stmt = conn.prepareStatement(sql);
        //4. 设置参数
        //5. 执行SQL
        ResultSet rs = stmt.executeQuery();
        //6. 处理结果 List<Brand> 封装Brand对象，装载List集合
        Learning_status learning_status;
        List<Learning_status> learning_statuses= new ArrayList<>();
        while (rs.next()) {
            //获取数据
            int id = rs.getInt("id");
            String course_name= rs.getString("course_name");
            String student_name = rs.getString("student_name");
            String chapter = rs.getString("chapter");
            String status = rs.getString("status");
            //封装course对象
            learning_status = new Learning_status();
            learning_status.setId(id);
            learning_status.setCourse_name(course_name);
            learning_status.setStudent_name(student_name);
            learning_status.setChapter(chapter);
            learning_status.setStatus(status);
            //装载集合
            learning_statuses.add(learning_status);
        }
        return learning_statuses;
    }

    public List<Learning_status> SelectAllByStudent_name(String student_name) throws SQLException {
        Connection conn;
        conn = DruidUtils.getConnection();
        String sql = "select * from learning_status WHERE student_name = ?;";
        //3. 获取stmt对象
        PreparedStatement stmt = conn.prepareStatement(sql);
        //4. 设置参数
        stmt.setString(1,student_name);
        //5. 执行SQL
        ResultSet rs = stmt.executeQuery();
        //6. 处理结果 List<Brand> 封装Brand对象，装载List集合
        Learning_status learning_status;
        List<Learning_status> learning_statuses= new ArrayList<>();
        while (rs.next()) {
            //获取数据
            int id = rs.getInt("id");
            String course_name= rs.getString("course_name");
            String chapter = rs.getString("chapter");
            String status = rs.getString("status");
            //封装course对象
            learning_status = new Learning_status();
            learning_status.setId(id);
            learning_status.setCourse_name(course_name);
            learning_status.setStudent_name(student_name);
            learning_status.setChapter(chapter);
            learning_status.setStatus(status);
            //装载集合
            learning_statuses.add(learning_status);
        }
        return learning_statuses;
    }
    public List<Learning_status> SelectAllByCourse_name(String course_name) throws SQLException {
        Connection conn;
        conn = DruidUtils.getConnection();
        String sql = "select * from learning_status WHERE course_name = ?;";
        //3. 获取stmt对象
        PreparedStatement stmt = conn.prepareStatement(sql);
        //4. 设置参数
        stmt.setString(1,course_name);
        //5. 执行SQL
        ResultSet rs = stmt.executeQuery();
        //6. 处理结果 List<Brand> 封装Brand对象，装载List集合
        Learning_status learning_status;
        List<Learning_status> learning_statuses= new ArrayList<>();
        while (rs.next()) {
            //获取数据
            int id = rs.getInt("id");
            String student_name= rs.getString("student_name");
            String chapter = rs.getString("chapter");
            String status = rs.getString("status");
            //封装course对象
            learning_status = new Learning_status();
            learning_status.setId(id);
            learning_status.setCourse_name(course_name);
            learning_status.setStudent_name(student_name);
            learning_status.setChapter(chapter);
            learning_status.setStatus(status);
            //装载集合
            learning_statuses.add(learning_status);
        }
        return learning_statuses;
    }

    public Learning_status selectById(int id) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        Learning_status learning_status = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "SELECT * FROM learning_status WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                learning_status = new Learning_status();
                learning_status.setId(rs.getInt("id"));
                learning_status.setCourse_name(rs.getString("course_name"));
                learning_status.setStudent_name(rs.getString("student_name"));
                learning_status.setChapter(rs.getString("chapter"));
                learning_status.setStatus(rs.getString("status"));
                // ... 设置其他属性 ...
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return learning_status; // 如果没有找到，返回null
    }
    public void update(Learning_status learning_status){
        Connection conn;
        try {
            conn = DruidUtils.getConnection();
            //2. 定义SQL
            String sql ="update learning_status set course_name = ?,student_name = ?,chapter = ?,status = ? where id = ?";
            //3. 获取stmt对象
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, learning_status.getCourse_name());
            stmt.setString(2, learning_status.getStudent_name());
            stmt.setString(3, learning_status.getChapter());
            stmt.setString(4, learning_status.getStatus());
            stmt.setInt(5, learning_status.getId());
            stmt.executeUpdate();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(int id){
        Connection conn;
        try {
            conn = DruidUtils.getConnection();
            //2. 定义SQL
            String sql ="delete from learning_status where id = ? ";
            //3. 获取stmt对象
            PreparedStatement stmt = conn.prepareStatement(sql);
            //4.设置参数
            stmt.setInt(1,id);
            stmt.executeUpdate();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
