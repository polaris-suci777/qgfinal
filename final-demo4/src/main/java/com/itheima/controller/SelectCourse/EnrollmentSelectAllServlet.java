package com.itheima.controller.SelectCourse;

import com.itheima.pojo.Enrollment;
import com.itheima.service.SelectCourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

@WebServlet("/enrollmentSelectAllServlet")
public class EnrollmentSelectAllServlet extends HttpServlet {
    private SelectCourseService service = new SelectCourseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        if(method!=null){
            method = new String(method.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        }
        //1. 接收id
        String student_name = request.getParameter("student_name");
        student_name = new String(student_name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        List<Enrollment> enrollments;
        enrollments = service.showSelectCourse(student_name);
        //2. 存入request域中
        request.setAttribute("enrollments", enrollments);
        if(Objects.equals(method, "manager")){
            request.getRequestDispatcher("/managerenrollment.jsp").forward(request, response);
        }
        else{
        request.getRequestDispatcher("/showselectcourse.jsp").forward(request, response);}

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}