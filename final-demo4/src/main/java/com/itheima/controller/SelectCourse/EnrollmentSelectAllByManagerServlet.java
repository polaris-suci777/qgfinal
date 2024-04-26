package com.itheima.controller.SelectCourse;

import com.itheima.pojo.Enrollment;
import com.itheima.pojo.Student_answer;
import com.itheima.pojo.Teacher;
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

@WebServlet("/enrollmentSelectAllByManagerServlet")
public class EnrollmentSelectAllByManagerServlet extends HttpServlet {
    private SelectCourseService service = new SelectCourseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Enrollment> enrollments;
        enrollments = service.selectall();
        //2. 存入request域中
        request.setAttribute("enrollments", enrollments);
        //3. 转发到student.jsp
        request.getRequestDispatcher("/managerenrollment.jsp").forward(request,response);}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


}
