package com.itheima.controller.discussion;

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


@WebServlet("/discussionSelectAllByStudentServlet")
public class DiscussionSelectAllByStudentServlet extends HttpServlet {
    DiscussionService service = new DiscussionService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        List<Discussion> discussions;
        //2. 存入request域中
        try {
            discussions = service.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("discussions", discussions);
        //3. 转发到course.jsp
            request.getRequestDispatcher("/studentdiscussion.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
