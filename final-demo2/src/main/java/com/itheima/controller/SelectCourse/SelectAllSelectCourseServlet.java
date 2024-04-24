package com.itheima.controller.SelectCourse;

import com.itheima.pojo.Course;
import com.itheima.pojo.Enrollment;
import com.itheima.service.CourseService;
import com.itheima.service.SelectCourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/selectAllSelectCourseServlet")
public class SelectAllSelectCourseServlet extends HttpServlet {
    private SelectCourseService service = new SelectCourseService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题

        request.setCharacterEncoding("utf-8");
        //1. 接收id
        String student_name = request.getParameter("student_name");
        student_name = new String(student_name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        List<Enrollment> enrollments;
        enrollments = service.showSelectCourse(student_name);

        //2. 存入request域中
        request.setAttribute("enrollments", enrollments);

        //3. 转发到course.jsp
//        if(student_name.equals("teacher")) {
//            request.getRequestDispatcher("/course.jsp").forward(request, response);
//        }
//        if(student_name.equals("student")) {
            request.getRequestDispatcher("/showselectcourse.jsp").forward(request, response);
       // }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}