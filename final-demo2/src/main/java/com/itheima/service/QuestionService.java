package com.itheima.service;

import com.itheima.dao.QuestionDao;
import com.itheima.dao.message.CourseDao;
import com.itheima.pojo.Course;
import com.itheima.pojo.Question;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class QuestionService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Question> selectAll() throws SQLException {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个course-dao对象
        QuestionDao questionDao = new QuestionDao();
        //4.调用方法
        List<Question> questions = questionDao.SelectAll();
        return questions;
    }
    public void add(Question question) throws Exception {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        QuestionDao questionDao = new QuestionDao();
        //4.调用方法
        questionDao.createQuestion(question);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }
    public Question selectById(int id){
        //调用BrandMapper.selectAll()
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        QuestionDao questionDao = new QuestionDao();
        //4.调用方法
        Question question=questionDao.selectById(id);

        sqlSession.close();
        return question;
    }


    public void delete(int id){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        QuestionDao questionDao = new QuestionDao();
        //4.调用方法
        questionDao.delete(id);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
}
