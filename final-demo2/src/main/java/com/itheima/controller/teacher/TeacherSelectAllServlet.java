package com.itheima.controller.teacher;

import com.itheima.pojo.Teacher;
import com.itheima.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/teacherSelectAllServlet")
public class TeacherSelectAllServlet extends HttpServlet {
    private TeacherService service = new TeacherService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 调用BrandService完成查询
        List<Teacher> teachers;
        try {
            teachers = service.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //2. 存入request域中
        request.setAttribute("teachers",teachers);

        //3. 转发到teacher.jsp
        request.getRequestDispatcher("/teacher.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}