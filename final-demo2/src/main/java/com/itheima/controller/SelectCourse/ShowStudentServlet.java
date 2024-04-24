package com.itheima.controller.SelectCourse;

import com.itheima.pojo.Enrollment;
import com.itheima.service.SelectCourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/showStudentServlet")
public class ShowStudentServlet extends HttpServlet {
    private SelectCourseService service =new SelectCourseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");

        //1. 接收表单提交的数据
        String course_name = request.getParameter("course_name");
        List<Enrollment> enrollments = new ArrayList<>();
        try {
            enrollments=service.showStudent(course_name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //2. 存入request域中
        request.setAttribute("enrollments", enrollments);

        //3. 转发到student.jsp
        request.getRequestDispatcher("/showstudent.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
