package com.itheima.controller.student;

import com.itheima.pojo.Student;

import com.itheima.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@WebServlet("/studentSelectByIdServlet")
public class StudentSelectByIdServlet extends HttpServlet {
    private StudentService service = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收id
        String id = request.getParameter("id");
        String method = request.getParameter("method");
        method = new String(method.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        //2. 调用service查询
        Student student = service.selectById(Integer.parseInt(id));
        //3. 存储到request中
        request.setAttribute("student", student);
        //4. 转发到update.jsp
        if(method.equals("teacher")){
        request.getRequestDispatcher("/studentupdatebyteacher.jsp").forward(request,response);}
        else if(method.equals("student")) {
            request.getRequestDispatcher("/studentupdate.jsp").forward(request,response);
        } else if (method.equals("manager")) {
            request.setAttribute("method", method);
            request.getRequestDispatcher("/managerupdatestudent.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}