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


@WebServlet("/learning_statusUpdateServlet")
public class Learning_statusUpdateServlet extends HttpServlet {
    Learning_statusService service = new Learning_statusService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        //1. 接收表单提交的数据，封装为一个course对象
        String id = request.getParameter("id");
        String course_name = request.getParameter("course_name");
        String student_name = request.getParameter("student_name");
        String chapter = request.getParameter("chapter");
        String status = request.getParameter("status");
        //封装为一个course对象
        Learning_status learning_status = new Learning_status();
        learning_status.setId(Integer.parseInt(id));
        learning_status.setCourse_name(course_name);
        learning_status.setStudent_name(student_name);
        learning_status.setChapter(chapter);
        learning_status.setStatus(status);
        //2. 调用service 完成修改
        service.update(learning_status);
        //3. 转发到查询所有Servlet
        request.getRequestDispatcher("/learning_statusSelectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
