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


@WebServlet("/learning_statusSelectByIdServlet")
public class Learning_statusSelectByIdServlet extends HttpServlet {
    Learning_statusService service = new Learning_statusService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收id
        String id = request.getParameter("id");
        //2. 调用service查询
        Learning_status learning_status = service.selectById(Integer.parseInt(id));
        //3. 存储到request中
        request.setAttribute("learning_status", learning_status);

        //4. 转发到update.jsp
        request.getRequestDispatcher("/learning_statusupdate.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
