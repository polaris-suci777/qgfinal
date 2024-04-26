package com.itheima.controller.question;

import com.itheima.pojo.Course;
import com.itheima.pojo.Question;
import com.itheima.service.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@WebServlet("/questionSelectAllByTeacherServlet")
public class QuestionSelectAllByTeacherServlet extends HttpServlet {
    private QuestionService service = new QuestionService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        if(method!=null){
            method = new String(method.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        }
        //1. 接收id
        List<Question>  questions;
        try {
            questions = service.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //2. 存入request域中
        request.setAttribute("questions", questions);
        //3. 转发到course.jsp
        if(Objects.equals(method, "manager")){
            request.getRequestDispatcher("/managerquestion.jsp").forward(request, response);
        }
        else{
        request.getRequestDispatcher("/question.jsp").forward(request, response);}




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
