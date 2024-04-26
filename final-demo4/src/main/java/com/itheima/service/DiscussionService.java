package com.itheima.service;

import com.itheima.dao.message.CourseDao;
import com.itheima.dao.message.DiscussionDao;
import com.itheima.pojo.Course;
import com.itheima.pojo.Discussion;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class DiscussionService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Discussion> selectAll() throws SQLException {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个course-dao对象
        DiscussionDao discussionDao = new DiscussionDao();
        //4.调用方法
        List<Discussion> discussions = discussionDao.SelectAll();
        return discussions;
    }
    public List<Discussion> selectAllByCourse_name(String course_name) throws SQLException {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个course-dao对象
        DiscussionDao discussionDao = new DiscussionDao();
        //4.调用方法
        List<Discussion> discussions = discussionDao.SelectAllByCourse_name(course_name);
        return discussions;
    }
    public void add(Discussion discussion) throws Exception {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        DiscussionDao discussionDao = new DiscussionDao();
        //4.调用方法
        discussionDao.createDiscussion(discussion);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
    public Discussion selectById(int id){
        //调用BrandMapper.selectAll()
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        DiscussionDao discussionDao = new DiscussionDao();
        //4.调用方法
        Discussion discussion = discussionDao.selectById(id);
        sqlSession.close();
        return discussion;
    }

    public Discussion selectByCourse_name(String course_name){
        //调用BrandMapper.selectAll()
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        DiscussionDao discussionDao = new DiscussionDao();
        //4.调用方法
        Discussion discussion = discussionDao.selectByCourse_name(course_name);
        sqlSession.close();
        return discussion;
    }

    public void update(Discussion discussion){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个course-dao对象
        DiscussionDao discussionDao = new DiscussionDao();
        //4.调用方法
        discussionDao.update(discussion);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
    public void delete(int id){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        DiscussionDao discussionDao = new DiscussionDao();
        //4.调用方法
        discussionDao.delete(id);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
}
