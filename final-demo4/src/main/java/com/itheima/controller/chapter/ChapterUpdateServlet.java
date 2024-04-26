package com.itheima.controller.chapter;

import com.itheima.pojo.Chapter;
import com.itheima.pojo.Course;
import com.itheima.service.ChapterService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChapterUpdateServlet extends HttpServlet {
    private ChapterService service = new ChapterService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        //1. 接收表单提交的数据，封装为一个course对象
        String id = request.getParameter("id");
        String course_name = request.getParameter("course_name");
        String unit = request.getParameter("unit");
        String lesson = request.getParameter("lesson");
        String description = request.getParameter("description");
        //封装为一个course对象
        Chapter chapter=new Chapter();
        chapter.setId(Integer.parseInt(id));
        chapter.setCourse_name(course_name);
        chapter.setUnit(unit);
        chapter.setLesson(lesson);
        chapter.setDescription(description);
        //2. 调用service 完成修改
        service.update(chapter);
        //3. 转发到查询所有Servlet
        request.getRequestDispatcher("/chapterSelectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
