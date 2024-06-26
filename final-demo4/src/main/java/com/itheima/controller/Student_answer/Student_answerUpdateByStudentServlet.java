package com.itheima.controller.Student_answer;

import com.itheima.pojo.Student_answer;
import com.itheima.service.Student_answerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@WebServlet("/student_answerUpdateByStudentServlet")
public class Student_answerUpdateByStudentServlet extends HttpServlet {
    private Student_answerService service = new Student_answerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        //1. 接收id
        //1. 接收表单提交的数据，封装为一个student对象
        String id = request.getParameter("id");
        String course_name = request.getParameter("course_name");
        String content = request.getParameter("content");
        String student_name = request.getParameter("student_name");
        String answer = request.getParameter("answer");
        String is_correct = request.getParameter("is_correct");
        String grade = request.getParameter("grade");
        //封装为一个course对象
        Student_answer student_answer = new Student_answer();
        student_answer.setId(Integer.parseInt(id));
        student_answer.setCourse_name(course_name);
        student_answer.setContent(content);
        student_answer.setStudent_name(student_name);
        student_answer.setAnswer(answer);
        student_answer.setIs_correct(is_correct);
        student_answer.setGrade(grade);
        //2. 调用service 完成修改
        service.update(student_answer);
        //3. 转发到查询所有Servlet
        request.setAttribute("course_name",course_name);
            request.getRequestDispatcher("/student_answerSelectAllByStudentServlet").forward(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
