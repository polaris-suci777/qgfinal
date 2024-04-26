package com.itheima.controller.learning_status;

import com.itheima.pojo.Course;
import com.itheima.pojo.Learning_status;
import com.itheima.service.Learning_statusService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/learning_statusSelectAllServlet")
public class Learning_statusSelectAllServlet extends HttpServlet {
    Learning_statusService service = new Learning_statusService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1. 接收id
        String method = request.getParameter("method");
        String course_name = request.getParameter("course_name");
        String student_name = request.getParameter("student_name");
        if(method!=null){
        method = new String(method.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        if(method.equals("teacher")) {
            course_name = new String(course_name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);}
        if(method.equals("student")) {
            student_name = new String(student_name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);}
        List<Learning_status> learning_statuses = new ArrayList<>();
        try {
            if(method.equals("teacher")) {
                learning_statuses= service.selectAllByCourse_name(course_name);
            }
            else if(method.equals("student")){
                learning_statuses= service.selectAllByStudent_name(student_name);
            }
            else if(method.equals("manager")){
                learning_statuses= service.selectAll();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //2. 存入request域中
        request.setAttribute("learning_statuses", learning_statuses);
        //3. 转发到course.jsp
        if(method.equals("teacher")){
            request.getRequestDispatcher("/statusteacher.jsp").forward(request,response);}
        else if(method.equals("student")){
            request.getRequestDispatcher("/statusstudent.jsp").forward(request,response);
        }
        else if(method.equals("manager")){
            request.getRequestDispatcher("/managerlearning_status.jsp").forward(request,response);
        }
        }
        else{
            request.getRequestDispatcher("/loginteacher.jsp").forward(request,response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
