package com.itheima.controller.SelectCourse;
import com.itheima.service.SelectCourseService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/enrollmentDeleteByStudentServlet")
public class EnrollmentDeleteByStudentServlet extends HttpServlet {
    private SelectCourseService service = new SelectCourseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收id
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        //2. 调用service删除
        service.delete(Integer.parseInt(id));
        //        3. 转发到查询所有Servlet
            request.getRequestDispatcher("/loginstudent.jsp").forward(request,response);}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
