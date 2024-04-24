package com.itheima.dao.message;

import com.itheima.pojo.Teacher;
import com.itheima.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {
    public Teacher createTeacher(Teacher teacher) throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = JDBCUtil.getConnection();
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
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Teacher> SelectAll() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        conn = JDBCUtil.getConnection();
        String sql = "select * from teacher;";
        //3. 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //4. 设置参数
        //5. 执行SQL
        ResultSet rs = pstmt.executeQuery();
        //6. 处理结果 List<Brand> 封装Brand对象，装载List集合
        Teacher teacher;
        List<Teacher> teachers = new ArrayList<>();
        while (rs.next()) {
            //获取数据
            int id = rs.getInt("id");
            String name= rs.getString("name");
            String password = rs.getString("password");
            String email = rs.getString("email");
            String qq = rs.getString("qq");
            String subject = rs.getString("subject");
            String introduction = rs.getString("introduction");
            //封装Brand对象
            teacher = new Teacher();
            teacher.setId(id);
            teacher.setName(name);
            teacher.setPassword(password);
            teacher.setEmail(email);
            teacher.setQq(qq);
            teacher.setSubject(subject);
            teacher.setIntroduction(introduction);

            //装载集合
            teachers.add(teacher);
        }
        return teachers;
    }
    public Teacher selectById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Teacher teacher = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM teacher WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
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
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return teacher; // 如果没有找到，返回null

    }
    public void update(Teacher teacher){
        Connection conn;
        try {
            conn = JDBCUtil.getConnection();

        //2. 定义SQL
        String sql ="update teacher set name = ?,password = ?,email = ?,qq = ?,subject=?,introduction=? where id = ?";
//        "update teacher set name = ?," +
//                "password = ?," +
//                "email = ?," +
//                "qq = ?," +
//                "subject = ? " +
//                "introduction = ? " +
//                "where id = ?";
            //3. 获取stmt对象
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, teacher.getName());
            stmt.setString(2, teacher.getPassword());
            stmt.setString(3, teacher.getEmail());
            stmt.setString(4, teacher.getQq());
            stmt.setString(5, teacher.getSubject());
            stmt.setString(6, teacher.getIntroduction());
            stmt.setInt(7,teacher.getId());
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
            String sql ="delete from teacher where id = ? ";
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
    // 其他方法如更新教师信息、删除教师等...  
}