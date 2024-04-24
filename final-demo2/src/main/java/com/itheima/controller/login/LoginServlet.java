package com.itheima.controller.login;
import com.itheima.pojo.Student;
import com.itheima.pojo.Teacher;
import com.itheima.service.LoginService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private LoginService service = new LoginService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        //1. 接收用户名和密码
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        if (type.equals("teacher")) {
            Teacher teacher;
            try {
                teacher = service.teacherSelect(name, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            //3. 判断user释放为null
            if (teacher != null) {
                // 登陆成功
                HttpSession session =request.getSession();
//                List<Teacher> teachers = new ArrayList<>();
//                teachers.add(teacher);
                session.setAttribute("teacher",teacher);
                response.sendRedirect("loginteacher.jsp");
            } else {
                // 登陆失败
                response.sendRedirect("index.html");
            }
        }

        if (type.equals("student")) {
            Student student;
            try {
                student = service.studentSelect(name, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            };
            //3. 判断user释放为null
            if (student != null) {
                // 登陆成功
                HttpSession session =request.getSession();
                session.setAttribute("student",student);
                response.sendRedirect("loginstudent.jsp");
            } else {
                response.sendRedirect("index.html");
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}