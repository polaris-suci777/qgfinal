package com.itheima.controller.student;

import com.itheima.pojo.Student;
import com.itheima.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/studentSelectAllByTeacherServlet")
public class StudentSelectAllByTeacherServlet extends HttpServlet {
    private StudentService service = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        //1. 接收id
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
        request.getRequestDispatcher("/student.jsp").forward(request,response);}


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

