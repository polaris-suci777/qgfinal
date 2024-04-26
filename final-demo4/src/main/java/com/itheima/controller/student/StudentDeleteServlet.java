package com.itheima.controller.student;

import com.itheima.service.StudentService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@WebServlet("/studentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet {
    private StudentService service = new StudentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收id
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        if(method!=null){
            method = new String(method.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        }
        String id = request.getParameter("id");
        //2. 调用service删除
        service.delete(Integer.parseInt(id));
        //        3. 转发到查询所有Servlet
        request.setAttribute("method", method);
        request.getRequestDispatcher("/studentSelectAllServlet").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
