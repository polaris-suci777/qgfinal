package com.itheima.controller.question;

import com.itheima.pojo.Course;
import com.itheima.pojo.Question;
import com.itheima.service.CourseService;
import com.itheima.service.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionUpdateServlet extends HttpServlet {
    private QuestionService service = new QuestionService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        //1. 接收表单提交的数据，封装为一个course对象
        String id = request.getParameter("id");
        String course_name = request.getParameter("course_name");
        String type = request.getParameter("type");
        String content = request.getParameter("content");
        String choiceA = request.getParameter("choiceA");
        String choiceB = request.getParameter("choiceB");
        String choiceC = request.getParameter("choiceC");
        String choiceD = request.getParameter("choiceD");
        String answer = request.getParameter("answer");
        //封装为一个course对象
        Question question =new Question();
        question.setId(Integer.valueOf(id));
        question.setCourse_name(course_name);
        question.setType(type);
        question.setContent(content);
        question.setChoicA(choiceA);
        question.setChoiceB(choiceB);
        question.setChoiceC(choiceC);
        question.setChoiceD(choiceD);
        question.setAnswer(answer);
        //2. 调用service 完成修改
//        service.update(question);
        //3. 转发到查询所有Servlet
        request.getRequestDispatcher("/courseSelectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
