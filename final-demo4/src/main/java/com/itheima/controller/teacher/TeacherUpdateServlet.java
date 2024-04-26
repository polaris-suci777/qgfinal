package com.itheima.controller.teacher;

import com.itheima.pojo.Teacher;
import com.itheima.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/teacherUpdateServlet")
public class TeacherUpdateServlet extends HttpServlet {
    private TeacherService service = new TeacherService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        method = new String(method.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        //1. 接收表单提交的数据，封装为一个teacher对象
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String qq = request.getParameter("qq");
        String subject = request.getParameter("subject");
        String introduction = request.getParameter("introduction");
        //封装为一个teacher对象
        Teacher teacher = new Teacher();
        teacher.setId(Integer.parseInt(id));
        teacher.setName(name);
        teacher.setPassword(password);
        teacher.setEmail(email);
        teacher.setQq(qq);
        teacher.setSubject(subject);
        teacher.setIntroduction(introduction);
        //2. 调用service 完成修改
        service.update(teacher);
        //3. 转发到查询所有Servlet
        HttpSession session =request.getSession();
        session.setAttribute("teacher",teacher);
        if(method.equals("informationsubmit")){
        response.sendRedirect("/final-demo4/teacherinformation.jsp");}
        else if(method.equals("passwordsubmit")){
            response.sendRedirect("/final-demo4/index.jsp");
        } else if (method.equals("manager")){
            request.setAttribute("method", method);
            request.getRequestDispatcher("/teacherSelectAllServlet").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}