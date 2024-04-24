package com.itheima.controller.chapter;

import com.itheima.pojo.Chapter;
import com.itheima.pojo.Course;
import com.itheima.service.ChapterService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChapterSelectByIdServlet extends HttpServlet {
    private ChapterService service = new ChapterService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收id
        String id = request.getParameter("id");
        //2. 调用service查询
        Chapter chapter= service.selectById(Integer.parseInt(id));
        //3. 存储到request中
        request.setAttribute("course", chapter);

        //4. 转发到update.jsp
        request.getRequestDispatcher("/chaptereupdate.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
