package com.itheima.controller.SelectCourse;

import com.itheima.service.SelectCourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@WebServlet("/enrollmentAddServlet")
public class EnrollmentAddServlet extends HttpServlet {
    private SelectCourseService service =new SelectCourseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        if(method!=null){
            method = new String(method.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        }
        //1. 接收表单提交的数据
        String course_name = request.getParameter("course_name");
        String student_name = request.getParameter("student_name");
        try {
            service.addSelectCourse(course_name,student_name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if(Objects.equals(method, "manager")){
            request.setAttribute("method", method);
            request.getRequestDispatcher("/enrollmentSelectAllByManagerServlet").forward(request,response);}
//        3. 转发到查询所有Servlet
        else {
        request.getRequestDispatcher("/loginstudent.jsp").forward(request,response);}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

