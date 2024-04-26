package com.itheima.controller.question;

import com.itheima.pojo.Course;
import com.itheima.pojo.Question;
import com.itheima.service.QuestionService;
import com.itheima.service.SelectCourseService;
import com.itheima.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/questionSelectAllServlet")
public class QuestionSelectAllServlet extends HttpServlet {
    private QuestionService service = new QuestionService();
    private SelectCourseService Tservice = new SelectCourseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        //1. 接收id
        String method = request.getParameter("method");
        String course_name = request.getParameter("course_name");
//        String student_name = request.getParameter("student_name");
        method = new String(method.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        if(method.equals("teacher")) {
        course_name = new String(course_name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);}
//        if(method.equals("student")) {
//        student_name = new String(student_name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);}
        List<Question> questions;
        try {
            if(method.equals("teacher")) {
            questions = service.selectAllByCourse_name(course_name);
            }
            else{
//                course_name=Tservice.selectByStudent_name(student_name);
                questions = service.selectAllByCourse_name(course_name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //2. 存入request域中
        request.setAttribute("questions", questions);

        //3. 转发到course.jsp
        if(method.equals("teacher")) {
            request.getRequestDispatcher("/question.jsp").forward(request, response);
        }
        if(method.equals("student")) {
            request.getRequestDispatcher("/studentquestion.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
