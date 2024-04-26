package com.itheima.controller.student;

import com.itheima.pojo.Student;
import com.itheima.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@WebServlet("/studentSelectAllServlet")
public class StudentSelectAllServlet extends HttpServlet {
    private StudentService service = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        //1. 接收id
        String method = request.getParameter("method");
        method = new String(method.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        //1. 调用BrandService完成查询
        List<Student> students;
        try {
            students = service.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //2. 存入request域中
        request.setAttribute("students", students);
        //3. 转发到student.jsp
        if(method.equals("teacher")){
        request.getRequestDispatcher("/student.jsp").forward(request,response);}
        else if(method.equals("student")){
            request.getRequestDispatcher("/studentinformation.jsp").forward(request,response);
        }
        else if (method.equals("manager")){
            request.setAttribute("method", method);
            request.getRequestDispatcher("/managerstudent.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}