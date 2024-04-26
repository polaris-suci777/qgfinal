package com.itheima.controller.Student_answer;


import com.itheima.service.Student_answerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@WebServlet("/student_answerDeleteServlet")
public class Student_answerDeleteServlet extends HttpServlet {
    private Student_answerService service = new Student_answerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收id
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String course_name = request.getParameter("course_name");
        String method = request.getParameter("method");
        if(method!=null){
            method = new String(method.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        }
        //2. 调用service删除
        service.delete(Integer.parseInt(id));
        //        3. 转发到查询所有Servlet
        if(Objects.equals(method, "manager")){
            request.setAttribute("method", method);
            request.getRequestDispatcher("/student_answerSelectAllByManagerServlet").forward(request, response);
        }
        else {
            request.setAttribute("course_name", course_name);
            request.getRequestDispatcher("/student_answerSelectAllByTeacherServlet").forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
