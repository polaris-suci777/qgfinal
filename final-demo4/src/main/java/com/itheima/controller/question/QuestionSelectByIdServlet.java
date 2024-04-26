package com.itheima.controller.question;

import com.itheima.pojo.Course;
import com.itheima.pojo.Question;
import com.itheima.service.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@WebServlet("/questionSelectByIdServlet")
public class QuestionSelectByIdServlet extends HttpServlet {
    private QuestionService service = new QuestionService();
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
        Question question = service.selectById(Integer.parseInt(id));
        //3. 存储到request中
        request.setAttribute("question", question);
        //4. 转发到update.jsp
        if(Objects.equals(method, "manager")){
            request.setAttribute("method", method);
            request.getRequestDispatcher("/managerupdatequestion.jsp").forward(request,response);
        }
        else{
        request.getRequestDispatcher("/questionupdate.jsp").forward(request,response);}

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
