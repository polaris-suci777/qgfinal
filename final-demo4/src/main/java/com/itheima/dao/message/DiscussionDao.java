package com.itheima.dao.message;

import com.itheima.pojo.Discussion;
import com.itheima.util.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiscussionDao {
    public Discussion createDiscussion(Discussion discussion) throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "INSERT INTO discussion (id, course_name, student_discussion,teacher_discussion) VALUES (null,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, discussion.getCourse_name());
            stmt.setString(2, discussion.getStudent_discussion());
            stmt.setString(3, discussion.getTeacher_discussion());
            stmt.executeUpdate();
            // 假设插入成功，返回插入的教师对象（在实际应用中，您可能需要从数据库重新检索以获取完整或更新的数据）
            return discussion;
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
    public List<Discussion> SelectAll() throws SQLException {
        Connection conn;
        conn = DruidUtils.getConnection();
        String sql = "select * from discussion;";
        //3. 获取pstmt对象
        PreparedStatement stmt = conn.prepareStatement(sql);
        //4. 设置参数
        //5. 执行SQL
        ResultSet rs = stmt.executeQuery();
        //6. 处理结果 List<Brand> 封装Brand对象，装载List集合
        Discussion discussion;
        List<Discussion> discussions = new ArrayList<>();
        while (rs.next()) {
            //获取数据
            int id = rs.getInt("id");
            String course_name= rs.getString("course_name");
            String student_discussion = rs.getString("student_discussion");
            String teacher_discussion = rs.getString("teacher_discussion");
            //封装course对象
            discussion = new Discussion();
            discussion.setId(id);
            discussion.setCourse_name(course_name);
            discussion.setStudent_discussion(student_discussion);
            discussion.setTeacher_discussion(teacher_discussion);
            //装载集合
            discussions.add(discussion);
        }
        return discussions;
    }

    public List<Discussion> SelectAllByCourse_name(String course_name) throws SQLException {
        Connection conn;
        conn = DruidUtils.getConnection();
        String sql = "select * from discussion WHERE course_name = ?;";
        //3. 获取pstmt对象
        PreparedStatement stmt = conn.prepareStatement(sql);
        //4. 设置参数
        stmt.setString(1,course_name);
        //5. 执行SQL
        ResultSet rs = stmt.executeQuery();
        //6. 处理结果 List<Brand> 封装Brand对象，装载List集合
        Discussion discussion;
        List<Discussion> discussions = new ArrayList<>();
        while (rs.next()) {
            //获取数据
            int id = rs.getInt("id");
            String student_discussion = rs.getString("student_discussion");
            String teacher_discussion = rs.getString("teacher_discussion");
            //封装course对象
            discussion = new Discussion();
            discussion.setId(id);
            discussion.setCourse_name(course_name);
            discussion.setStudent_discussion(student_discussion);
            discussion.setTeacher_discussion(teacher_discussion);
            //装载集合
            discussions.add(discussion);
        }
        return discussions;
    }
    public Discussion selectById(int id) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        Discussion discussion = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "SELECT * FROM discussion WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                discussion = new Discussion();
                discussion.setId(rs.getInt("id"));
                discussion.setCourse_name(rs.getString("course_name"));
                discussion.setStudent_discussion(rs.getString("student_discussion"));
                discussion.setTeacher_discussion(rs.getString("teacher_discussion"));
                // ... 设置其他属性 ...
            }
            rs.close();
            stmt.close();
            conn.close();;;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discussion; // 如果没有找到，返回null

    }

    public Discussion selectByCourse_name(String course_name) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        Discussion discussion = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "SELECT * FROM discussion WHERE course_name = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, course_name);
            rs = stmt.executeQuery();
            if (rs.next()) {
                discussion = new Discussion();
                discussion.setId(rs.getInt("id"));
                discussion.setCourse_name(rs.getString("course_name"));
                discussion.setStudent_discussion(rs.getString("student_discussion"));
                discussion.setTeacher_discussion(rs.getString("teacher_discussion"));
                // ... 设置其他属性 ...
            }
            rs.close();
            stmt.close();
            conn.close();;;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discussion; // 如果没有找到，返回null

    }
    public void update(Discussion discussion){
        Connection conn;
        try {
            conn = DruidUtils.getConnection();

            //2. 定义SQL
            String sql ="update discussion set course_name = ?,student_discussion = ?,teacher_discussion = ? where id = ?";
            //3. 获取stmt对象
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, discussion.getCourse_name());
            stmt.setString(2, discussion.getStudent_discussion());
            stmt.setString(3, discussion.getTeacher_discussion());
            stmt.setInt(4, discussion.getId());
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
            String sql ="delete from discussion where id = ? ";
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

