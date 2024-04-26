package com.itheima.controller.Student_answer;

import com.itheima.pojo.Student_answer;
import com.itheima.service.Student_answerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/student_answerSelectAllByManagerServlet")
public class Student_answerSelectAllByManagerServlet extends HttpServlet {
    private Student_answerService service = new Student_answerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student_answer> student_answers;
        try {
            student_answers = service.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //2. 存入request域中
        request.setAttribute("student_answers", student_answers);
        //3. 转发到student.jsp
        request.getRequestDispatcher("/managerstudent_answer.jsp").forward(request,response);}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
