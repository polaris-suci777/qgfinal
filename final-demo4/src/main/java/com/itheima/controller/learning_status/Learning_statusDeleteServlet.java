package com.itheima.controller.learning_status;

import com.itheima.service.Learning_statusService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;


@WebServlet("/learning_statusDeleteServlet")
public class Learning_statusDeleteServlet extends HttpServlet {
    Learning_statusService service = new Learning_statusService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收id
        String id = request.getParameter("id");
        String method = request.getParameter("method");
        String course_name = request.getParameter("course_name");
        if(method!=null){
            method = new String(method.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        }
        if(Objects.equals(method, "teacher")){
            course_name = new String(course_name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        }
        //2. 调用service删除
        service.delete(Integer.parseInt(id));
        if(Objects.equals(method, "teacher")){
            request.setAttribute("method", method);
            request.setAttribute("course_name", course_name);
            request.getRequestDispatcher("/learning_statusSelectAllServlet").forward(request, response);
        }
        //        3. 转发到查询所有Servlet
        else {
            request.setAttribute("method", method);
            request.getRequestDispatcher("/learning_statusSelectAllServlet").forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
