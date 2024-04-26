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

@WebServlet("/courseSelectByIdServlet")
public class CourseSelectByIdServlet extends HttpServlet {
    private CourseService service = new CourseService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收id
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String method = request.getParameter("method");
        if(method!=null){
            method = new String(method.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        }
        //2. 调用service查询
        Course course = service.selectById(Integer.parseInt(id));
        //3. 存储到request中
        request.setAttribute("course", course);
        //4. 转发到update.jsp
        if(Objects.equals(method, "manager")){
            request.setAttribute("method", method);
            request.getRequestDispatcher("/managerupdatecoourse.jsp").forward(request,response);
        }
        else{
        request.getRequestDispatcher("/courseupdate.jsp").forward(request,response);}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}