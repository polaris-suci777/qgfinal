package com.itheima.controller.student;
import com.itheima.pojo.Student;
import com.itheima.service.StudentService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/studentUpdateServlet")
public class StudentUpdateServlet extends HttpServlet {
    private StudentService service = new StudentService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        //1. 接收表单提交的数据，封装为一个student对象
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String studentnumber = request.getParameter("studentnumber");
        String grade = request.getParameter("grade");
        String introduction = request.getParameter("introduction");
        String sex = request.getParameter("sex");
        //封装为一个course对象
        Student student = new Student();
        student.setId(Integer.parseInt(id));
        student.setName(name);
        student.setPassword(password);
        student.setStudentnumber(studentnumber);
        student.setGrade(grade);
        student.setIntroduction(introduction);
        student.setSex(sex);
        //2. 调用service 完成修改
        service.update(student);
        //3. 转发到查询所有Servlet
        request.getRequestDispatcher("/loginteacher.jsp").forward(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}