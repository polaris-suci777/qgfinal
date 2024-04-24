package com.itheima.dao;

import com.itheima.pojo.Chapter;
import com.itheima.pojo.Course;
import com.itheima.pojo.Student;
import com.itheima.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChapterDao {

    public List<Chapter> SelectAll(String course_name) throws SQLException {
        Connection conn;
        conn = JDBCUtil.getConnection();
        String sql = "select * from chapter  WHERE course_name = ?";
        //3. 获取stmt对象
        PreparedStatement stmt = conn.prepareStatement(sql);
        //4. 设置参数
        stmt.setString(1, course_name);
        //5. 执行SQL
        ResultSet rs = stmt.executeQuery();
        //6. 处理结果 List<Brand> 封装Brand对象，装载List集合
        Chapter chapter;
        List<Chapter> chapters = new ArrayList<>();
        while (rs.next()) {
            //获取数据
            int id = rs.getInt("id");
            String unit = rs.getString("unit");
            String lesson = rs.getString("lesson");
            String description =rs.getString("description");
            //封装course对象
           chapter= new Chapter();
           chapter.setId(id);
           chapter.setCourse_name(course_name);
           chapter.setUnit(unit);
           chapter.setLesson(lesson);
           chapter.setDescription(description);
            //装载集合
            chapters.add(chapter);
        }
        return chapters;
    }

    public Chapter createChapter(Chapter chapter) throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO chapter (id, course_name,unit,lesson,description) VALUES (null,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, chapter.getCourse_name());
            stmt.setString(2, chapter.getUnit());
            stmt.setString(3, chapter.getLesson());
            stmt.setString(4,chapter.getDescription());
            stmt.executeUpdate();
            // 假设插入成功，返回插入的教师对象（在实际应用中，您可能需要从数据库重新检索以获取完整或更新的数据）
            return chapter;
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


    public Chapter selectById(int id) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        Chapter chapter = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM chapter WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                chapter = new Chapter();
                chapter.setId(rs.getInt("id"));
                chapter.setCourse_name(rs.getString("course_name"));
                chapter.setUnit(rs.getString("unit"));
                chapter.setLesson(rs.getString("lesson"));
                chapter.setDescription(rs.getString("description"));
                // ... 设置其他属性 ...
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chapter; // 如果没有找到，返回null

    }

    public void update(Chapter chapter){
        Connection conn;
        try {
            conn = JDBCUtil.getConnection();
            //2. 定义SQL
            String sql ="update chapter set course_name = ?,unit = ?,lesson = ?,descrption =? where id = ?";
            //3. 获取stmt对象
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, chapter.getCourse_name());
            stmt.setString(2, chapter.getUnit());
            stmt.setString(3, chapter.getLesson());
            stmt.setString(4,chapter.getDescription());
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
            conn = JDBCUtil.getConnection();
            //2. 定义SQL
            String sql ="delete from chapter where id = ? ";
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
