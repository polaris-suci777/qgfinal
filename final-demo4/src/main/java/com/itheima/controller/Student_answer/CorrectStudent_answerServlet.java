package com.itheima.controller.Student_answer;

import com.itheima.pojo.Student_answer;
import com.itheima.service.Student_answerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/student_answerCorrectServlet")
public class CorrectStudent_answerServlet extends HttpServlet {
    private Student_answerService service = new Student_answerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        Student_answer student_answer = service.selectById(Integer.parseInt(id));
        HttpSession session =request.getSession();
        session.setAttribute("student_answer",student_answer);
//        3. 转发到查询所有Servlet
        request.getRequestDispatcher("/correctstudent_answer.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
