package com.itheima.controller.Student_answer;


import com.itheima.pojo.Student;
import com.itheima.pojo.Student_answer;
import com.itheima.service.Student_answerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@WebServlet("/student_answerSelectByIdServlet")
public class Student_answerSelectByIdServlet extends HttpServlet {
    private Student_answerService service = new Student_answerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收id
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        if(method!=null){
            method = new String(method.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        }
        String id = request.getParameter("id");
        //2. 调用service查询
        Student_answer student_answer = service.selectById(Integer.parseInt(id));
        //3. 存储到request中
        request.setAttribute("student_answer", student_answer);
        //4. 转发到update.jsp
        if(Objects.equals(method, "manager")){
            request.setAttribute("method", method);
            request.getRequestDispatcher("/managerupdatestudent_answer.jsp").forward(request,response);
        }
        else {
            request.getRequestDispatcher("/student_answerupdate.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
