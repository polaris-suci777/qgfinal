package com.itheima.controller.student;

import com.itheima.pojo.Student;

import com.itheima.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/studentSelectByIdServlet")
public class StudentSelectByIdServlet extends HttpServlet {
    private StudentService service = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收id
        String id = request.getParameter("id");
        //2. 调用service查询
        Student student = service.selectById(Integer.parseInt(id));
        //3. 存储到request中
        request.setAttribute("course", student);

        //4. 转发到update.jsp
        request.getRequestDispatcher("/studentupdate.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}