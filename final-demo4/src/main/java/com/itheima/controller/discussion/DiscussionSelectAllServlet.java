package com.itheima.controller.discussion;

import com.itheima.pojo.Course;
import com.itheima.pojo.Discussion;
import com.itheima.service.DiscussionService;
import com.itheima.service.SelectCourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/discussionSelectAllServlet")
public class DiscussionSelectAllServlet extends HttpServlet {
    DiscussionService service = new DiscussionService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        //1. 接收id
        String method = request.getParameter("method");
        String course_name = request.getParameter("course_name");
        method = new String(method.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        course_name = new String(course_name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        List<Discussion> discussions;
        try {
            discussions = service.selectAllByCourse_name(course_name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //2. 存入request域中
        request.setAttribute("discussions", discussions);
        //3. 转发到course.jsp
        request.getRequestDispatcher("/discussion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
