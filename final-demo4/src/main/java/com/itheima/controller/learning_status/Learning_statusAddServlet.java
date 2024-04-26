package com.itheima.controller.learning_status;

import com.itheima.pojo.Course;
import com.itheima.pojo.Learning_status;
import com.itheima.service.Learning_statusService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/learning_statusAddServlet")
public class Learning_statusAddServlet extends HttpServlet {
    Learning_statusService service = new Learning_statusService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        //1. 接收表单提交的数据，封装为一个course对象
        String course_name = request.getParameter("course_name");
        String student_name = request.getParameter("student_name");
        String chapter = request.getParameter("chapter");
        String status = request.getParameter("status");
        course_name = new String(course_name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        chapter = new String(chapter.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        //封装为一个course对象
        Learning_status learning_status = new Learning_status();
        learning_status.setCourse_name(course_name);
        learning_status.setStudent_name(student_name);
        learning_status.setChapter(chapter);
        learning_status.setStatus(status);
        //2. 调用service 完成添加
        try {
            service.add(learning_status);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        3. 转发到查询所有Servlet
        request.getRequestDispatcher("/loginstudent.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
