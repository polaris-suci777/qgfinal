package com.itheima.controller.discussion;

import com.itheima.pojo.Course;
import com.itheima.pojo.Discussion;
import com.itheima.service.DiscussionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;


@WebServlet("/discussionAddServlet")
public class DiscussionAddServlet extends HttpServlet {
    DiscussionService service = new DiscussionService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        //1. 接收表单提交的数据，封装为一个course对象
        String course_name = request.getParameter("course_name");
        String student_discussion = request.getParameter("student_discussion");
        String teacher_discussion = request.getParameter("teacher_discussion");
        String method = request.getParameter("method");
        if(method!=null){
            method = new String(method.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        }
        //封装为一个discussion对象
        Discussion discussion = new Discussion();
        discussion.setCourse_name(course_name);
        discussion.setStudent_discussion(student_discussion);
        discussion.setTeacher_discussion(teacher_discussion);
        //2. 调用service 完成添加
        try {
            service.add(discussion);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if(Objects.equals(method, "manager")){
            request.setAttribute("method", method);
            request.getRequestDispatcher("/discussionSelectAllByTeacherServlet").forward(request, response);
        }
        else {
//        3. 转发到查询所有Servlet
        request.getRequestDispatcher("/discussionSelectAllByStudentServlet").forward(request,response);}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
