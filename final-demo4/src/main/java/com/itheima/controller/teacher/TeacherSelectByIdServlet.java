package com.itheima.controller.teacher;

import com.itheima.pojo.Teacher;
import com.itheima.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@WebServlet("/teacherSelectByIdServlet")
public class TeacherSelectByIdServlet extends HttpServlet {
    private TeacherService service = new TeacherService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1. 接收id
        String id = request.getParameter("id");
        //处理POST请求的乱码问题
        String method = request.getParameter("method");
        if(method!=null){
            method = new String(method.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        }
        //2. 调用service查询
        Teacher teacher = service.selectById(Integer.parseInt(id));
        //3. 存储到request中
        request.setAttribute("teacher",teacher);

        //4. 转发到update.jsp
        if(Objects.equals(method, "manager")){
            request.setAttribute("method", method);
            request.getRequestDispatcher("/managerupdateteacher.jsp").forward(request,response);
        }
        else{
            request.getRequestDispatcher("/teacherupdate.jsp").forward(request,response);}


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}