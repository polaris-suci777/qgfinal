package com.itheima.controller.student;

import com.itheima.pojo.Student;
import com.itheima.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@WebServlet("/studentAddServlet")
public class StudentAddServlet extends HttpServlet {
    private StudentService service = new StudentService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        if(method!=null){
            method = new String(method.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        }
        //1. 接收表单提交的数据，封装为一个student对象
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String studentnumber = request.getParameter("studentnumber");
        String grade = request.getParameter("grade");
        String introduction = request.getParameter("introduction");
        String sex = request.getParameter("sex");

        //封装为一个student对象
        Student student = new Student();
        student.setName(name);
        student.setPassword(password);
        student.setStudentnumber(studentnumber);
        student.setGrade(grade);
        student.setIntroduction(introduction);
        student.setSex(sex);



        //2. 调用service 完成添加
        try {
            service.add(student);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if(Objects.equals(method, "manager")){
            request.setAttribute("method", method);
            request.getRequestDispatcher("/studentSelectAllServlet").forward(request,response);}

//        3. 转发到查询所有Servlet
        else {
            request.getRequestDispatcher("/studentSelectAllByTeacherServlet").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}