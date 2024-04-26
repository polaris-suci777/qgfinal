package com.itheima.controller.register;
import com.itheima.pojo.Manager;
import com.itheima.pojo.Student;
import com.itheima.pojo.Teacher;
import com.itheima.service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private RegisterService service = new RegisterService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        //1. 接收用户名和密码
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        // 获取用户输入的验证码
        String checkCode = request.getParameter("checkCode");
        // 程序生成的验证码，从Session获取
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");
        // 比对
        if(!checkCodeGen.equalsIgnoreCase(checkCode)){
            request.setAttribute("register_msg","验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            // 不允许注册
            return;
        }

        if (type.equals("teacher")) {
            Teacher teacher=new Teacher();
            teacher.setName(name);
            teacher.setPassword(password);
            boolean flag;
            try {
                flag = service.registerTeacher(teacher);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            //3. 判断注册成功与否
            if(flag){
                //注册功能，跳转登陆页面
                request.setAttribute("register_msg","注册成功，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else {
                //注册失败，跳转到注册页面
                request.setAttribute("register_msg","用户名已存在");
                request.getRequestDispatcher("/register.jsp").forward(request,response);
            }
        }

        if (type.equals("student")) {
            Student student=new Student();
            student.setName(name);
            student.setPassword(password);
            boolean flag;
            try {
                flag = service.registerStudent(student);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            //3. 判断注册成功与否
            if(flag){
                //注册功能，跳转登陆页面
                request.setAttribute("register_msg","注册成功，请登录");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }else {
                //注册失败，跳转到注册页面
                request.setAttribute("register_msg","用户名已存在");
                request.getRequestDispatcher("/register.jsp").forward(request,response);
            }
        }

        if (type.equals("manager")) {
            Manager manager = new Manager();
            manager.setName(name);
            manager.setPassword(password);
            boolean flag;
            try {
                flag = service.registerManager(manager);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            //3. 判断注册成功与否
            if(flag){
                //注册功能，跳转登陆页面
                request.setAttribute("register_msg","注册成功，请登录");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }else {
                //注册失败，跳转到注册页面
                request.setAttribute("register_msg","用户名已存在");
                request.getRequestDispatcher("/register.jsp").forward(request,response);
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
