package com.itheima.controller.teacher;

import com.itheima.pojo.Teacher;
import com.itheima.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacherAddServlet")
public class TeacherAddServlet extends HttpServlet {
    private TeacherService service = new TeacherService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");

        //1. 接收表单提交的数据，封装为一个teacher对象
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String qq = request.getParameter("qq");
        String subject = request.getParameter("subject");
        String introduction = request.getParameter("introduction");

        //封装为一个teacher对象
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setEmail(email);
        teacher.setIntroduction(introduction);
        teacher.setQq(qq);
        teacher.setPassword(password);
        teacher.setSubject(subject);


        //2. 调用service 完成添加
        try {
            service.add(teacher);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


//        3. 转发到查询所有Servlet
        request.getRequestDispatcher("/teacherSelectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}