package com.itheima.controller.teacher;

import com.itheima.pojo.Teacher;
import com.itheima.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/teacherSelectByIdServlet")
public class TeacherSelectByIdServlet extends HttpServlet {
    private TeacherService service = new TeacherService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收id
        String id = request.getParameter("id");
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
//        //1. 接收id
//        String method = request.getParameter("method");
//        method = new String(method.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        //2. 调用service查询
        Teacher teacher = service.selectById(Integer.parseInt(id));
        //3. 存储到request中
        request.setAttribute("teacher",teacher);
//        request.setAttribute("method",method);

        //4. 转发到update.jsp
        request.getRequestDispatcher("/teacherupdate.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}