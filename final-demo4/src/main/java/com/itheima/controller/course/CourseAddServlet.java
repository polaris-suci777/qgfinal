package com.itheima.controller.course;

import com.itheima.pojo.Course;
import com.itheima.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@WebServlet("/courseAddServlet")
public class CourseAddServlet extends HttpServlet {
    private CourseService service = new CourseService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        if(method!=null){
            method = new String(method.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        }

        //1. 接收表单提交的数据，封装为一个course对象
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String stratdate = request.getParameter("startdate");
        String enddate = request.getParameter("enddate");
        int enrollmentlimit = Integer.parseInt(request.getParameter("enrollmentlimit"));

        //封装为一个course对象
        Course course = new Course();
        course.setName(name);
        course.setDescription(description);
        course.setStartdate(stratdate);
        course.setEnddate(enddate);
        course.setEnrollmentlimit(enrollmentlimit);

        //2. 调用service 完成添加
        try {
            service.add(course);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if(Objects.equals(method, "manager")){
            request.setAttribute("method", method);
            request.getRequestDispatcher("/courseSelectAllByTeacherServlet").forward(request, response);
        }
//        3. 转发到查询所有Servlet
        else {
            request.getRequestDispatcher("/courseSelectAllByTeacherServlet").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}