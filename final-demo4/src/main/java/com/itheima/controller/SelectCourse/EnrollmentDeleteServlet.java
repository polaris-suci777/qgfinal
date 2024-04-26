package com.itheima.controller.SelectCourse;

import com.itheima.service.SelectCourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@WebServlet("/enrollmentDeleteServlet")
public class EnrollmentDeleteServlet extends HttpServlet {
    private SelectCourseService service = new SelectCourseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收id
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        method = new String(method.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        String id = request.getParameter("id");
        //2. 调用service删除
        service.delete(Integer.parseInt(id));
        //        3. 转发到查询所有Servlet
        if(Objects.equals(method, "manager")){
            request.setAttribute("method", method);
            request.getRequestDispatcher("/enrollmentSelectAllByManagerServlet").forward(request,response);}
        else{
        request.getRequestDispatcher("/loginteacher.jsp").forward(request,response);}
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
