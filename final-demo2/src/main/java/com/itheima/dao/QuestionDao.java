package com.itheima.dao;

import com.itheima.pojo.Course;
import com.itheima.pojo.Question;
import com.itheima.pojo.Question;

import com.itheima.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {
    public Question createQuestion(Question question) throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO question (id, Question_name, type,content,choiceA,choiceB,choiceC,choiceD,answer) VALUES (null,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, question.getCourse_name());
            stmt.setString(2, question.getType());
            stmt.setString(3, question.getContent());
            stmt.setString(4, question.getChoicA());
            stmt.setString(5, question.getChoiceB());
            stmt.setString(6, question.getChoiceC());
            stmt.setString(7, question.getChoiceD());
            stmt.setString(8, question.getAnswer());
            stmt.executeUpdate();
            // 假设插入成功，返回插入的教师对象（在实际应用中，您可能需要从数据库重新检索以获取完整或更新的数据）
            return question;
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
    public List<Question> SelectAll() throws SQLException {
        Connection conn;
        conn = JDBCUtil.getConnection();
        String sql = "select * from question;";
        //3. 获取stmt对象
        PreparedStatement stmt = conn.prepareStatement(sql);
        //4. 设置参数
        //5. 执行SQL
        ResultSet rs = stmt.executeQuery();
        //6. 处理结果 List<Brand> 封装Brand对象，装载List集合
        Question question;
        List<Question> questions = new ArrayList<>();
        while (rs.next()) {
            //获取数据
            int id = rs.getInt("id");
            String course_name= rs.getString("course_name");
            String type = rs.getString("type");
            String content = rs.getString("content");
            String choiceA = rs.getString("choiceA");
            String choiceB = rs.getString("choiceB");
            String choiceC = rs.getString("choiceC");
            String choiceD = rs.getString("choiceD");
            String answer = rs.getString("answer");
            //封装Question对象
            question = new Question();
            question.setId(id);
            question.setCourse_name(course_name);
            question.setType(type);
            question.setContent(content);
            question.setChoicA(choiceA);
            question.setChoiceB(choiceB);
            question.setChoiceC(choiceC);
            question.setChoiceD(choiceD);
            question.setAnswer(answer);
            //装载集合
            questions.add(question);
        }
        return questions;
    }
    public Question selectById(int id) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        Question question = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM question WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                question = new Question();
                question.setId(rs.getInt("id"));
                question.setCourse_name(rs.getString("course_name"));
                question.setType(rs.getString("type"));
                question.setContent(rs.getString("content"));
                question.setChoicA(rs.getString("choiceA"));
                question.setChoiceB(rs.getString("choiceB"));
                question.setChoiceC(rs.getString("choiceC"));
                question.setChoiceD(rs.getString("choiceD"));
                question.setAnswer(rs.getString("answer"));
                // ... 设置其他属性 ...
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question; // 如果没有找到，返回null

    }



    public void delete(int id){
        Connection conn;
        try {
            conn = JDBCUtil.getConnection();
            //2. 定义SQL
            String sql ="delete from question where id = ? ";
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
