package com.itheima.controller.course;

import com.itheima.pojo.Course;
import com.itheima.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/courseUpdateServlet")
public class CourseUpdateServlet extends HttpServlet {
    private CourseService service = new CourseService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        //1. 接收表单提交的数据，封装为一个course对象
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String startdate = request.getParameter("startdate");
        String enddate = request.getParameter("enddate");
        String enrollmentlimit = request.getParameter("enrollmentlimit");
        //封装为一个course对象
        Course course = new Course();
        course.setId(Integer.parseInt(id));
        course.setName(name);
        course.setDescription(description);
        course.setStartdate(startdate);
        course.setEnddate(enddate);
        course.setEnrollmentlimit(Integer.valueOf(enrollmentlimit));
        //2. 调用service 完成修改
        service.update(course);
        //3. 转发到查询所有Servlet
        request.getRequestDispatcher("/courseSelectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}