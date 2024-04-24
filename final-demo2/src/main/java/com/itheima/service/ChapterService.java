package com.itheima.service;

import com.itheima.dao.ChapterDao;
import com.itheima.dao.message.CourseDao;
import com.itheima.pojo.Chapter;
import com.itheima.pojo.Course;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class ChapterService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Chapter> selectAll(String course_name) throws SQLException {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个course-dao对象
        ChapterDao chapterDao = new ChapterDao();
        //4.调用方法
        List<Chapter> chapters = chapterDao.SelectAll(course_name);
        return chapters;
    }
    public void add(Chapter chapter) throws Exception {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        ChapterDao chapterDao = new ChapterDao();
        //4.调用方法
        chapterDao.createChapter(chapter);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
    public Chapter selectById(int id){
        //调用BrandMapper.selectAll()
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        ChapterDao chapterDao = new ChapterDao();
        //4.调用方法
        Chapter chapter=chapterDao.selectById(id);
        sqlSession.close();
        return chapter;
    }
    public void update(Chapter chapter){

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();

        //3.新建一个course-dao对象
        ChapterDao chapterDao = new ChapterDao();
        //4.调用方法
        chapterDao.update(chapter);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
    public void delete(int id){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        ChapterDao chapterDao = new ChapterDao();
        //4.调用方法
        chapterDao.delete(id);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
}
