package com.itheima.controller.chapter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Chapter;
import com.itheima.service.ChapterService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/chapterSelectAllServlet")
public class ChapterSelectAllServlet extends HttpServlet {
        private ChapterService service = new ChapterService();
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //处理POST请求的乱码问题
            request.setCharacterEncoding("utf-8");
            //1. 接收id
            String course_name = request.getParameter("name");
            if(course_name!=null){
            course_name  = new String(course_name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);}
            //1. 调用BrandService完成查询
            List<Chapter> chapters;
            try {
                chapters = service.selectAll(course_name);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            //2. 存入request域中
            request.setAttribute("chapters", chapters);

            //3. 转发到course.jsp
            request.getRequestDispatcher("/chapter.jsp").forward(request,response);
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
