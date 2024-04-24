package com.itheima.dao;
import com.itheima.pojo.Student;
import com.itheima.pojo.Student_answer;
import com.itheima.util.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Student_answerDao {
    public Student_answer createStudent_answer(Student_answer student_answer) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO student_answer (id, course_name, student_name,answer,is_correct,grade) VALUES (null,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, student_answer.getCourse_name());
            stmt.setString(2, student_answer.getStudent_name());
            stmt.setString(3, student_answer.getAnswer());
            stmt.setString(4, student_answer.getIs_correct());
            stmt.setString(5, student_answer.getGrade());
            stmt.executeUpdate();
            // 假设插入成功，返回插入的教师对象（在实际应用中，您可能需要从数据库重新检索以获取完整或更新的数据）
            return student_answer;
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

    public List<Student_answer> SelectAll() throws SQLException {
        Connection conn;
        conn = JDBCUtil.getConnection();
        String sql = "select * from student_answer;";
        //3. 获取stmt对象
        PreparedStatement stmt = conn.prepareStatement(sql);
        //4. 设置参数
        //5. 执行SQL
        ResultSet rs = stmt.executeQuery();
        //6. 处理结果 List<Brand> 封装Brand对象，装载List集合
        Student_answer student_answer;
        List<Student_answer> student_answers = new ArrayList<>();
        while (rs.next()) {
            //获取数据
            int id = rs.getInt("id");
            String course_name = rs.getString("course_name");
            String student_name = rs.getString("student_name");
            String answer = rs.getString("answer");
            String is_correct = rs.getString("is_correct");
            String grade = rs.getString("greade");
            //封装course对象
            student_answer = new Student_answer();
            student_answer.setId(id);
            student_answer.setCourse_name(course_name);
            student_answer.setStudent_name(student_name);
            student_answer.setAnswer(answer);
            student_answer.setIs_correct(is_correct);
            student_answer.setGrade(grade);
            //装载集合
            student_answers.add(student_answer);
        }
        return student_answers;
    }

    public Student_answer selectById(int id) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        Student_answer student_answer = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM student_answer WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                student_answer = new Student_answer();
                student_answer.setId(rs.getInt("id"));
                student_answer.setCourse_name(rs.getString("course_name"));
                student_answer.setStudent_name(rs.getString("student_name"));
                student_answer.setAnswer(rs.getString("answer"));
                student_answer.setIs_correct(rs.getString("is_correct"));
                student_answer.setGrade(rs.getString("grade"));
                // ... 设置其他属性 ...
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student_answer; // 如果没有找到，返回null
    }

    public void update(Student_answer student_answer) {
        Connection conn;
        try {
            conn = JDBCUtil.getConnection();
            //2. 定义SQL
            String sql = "update student_answer set course_name = ?,student_name = ?,answer = ?,is_correct = ?,grade=? where id = ?";
            //3. 获取stmt对象
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, student_answer.getCourse_name());
            stmt.setString(2, student_answer.getStudent_name());
            stmt.setString(3, student_answer.getAnswer());
            stmt.setString(4, student_answer.getIs_correct());
            stmt.setString(5, student_answer.getGrade());
            stmt.setInt(6, student_answer.getId());
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
            String sql ="delete from student_answer where id = ? ";
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


