package com.itheima.service;

import com.itheima.dao.Learning_statusDao;
import com.itheima.pojo.Course;
import com.itheima.pojo.Learning_status;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class Learning_statusService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Learning_status> selectAll() throws SQLException {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个course-dao对象
        Learning_statusDao learning_statusDao =new Learning_statusDao();
        //4.调用方法
        List<Learning_status> learningStatuses = learning_statusDao.SelectAll();
        return learningStatuses;
    }
    public List<Learning_status> selectAllByStudent_name(String studnet_name) throws SQLException {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个course-dao对象
        Learning_statusDao learning_statusDao =new Learning_statusDao();
        //4.调用方法
        List<Learning_status> learningStatuses = learning_statusDao.SelectAllByStudent_name(studnet_name);
        return learningStatuses;
    }
    public List<Learning_status> selectAllByCourse_name(String course_name) throws SQLException {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个course-dao对象
        Learning_statusDao learning_statusDao =new Learning_statusDao();
        //4.调用方法
        List<Learning_status> learningStatuses = learning_statusDao.SelectAllByCourse_name(course_name);
        return learningStatuses;
    }
    public void add(Learning_status learning_status) throws Exception {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        Learning_statusDao learning_statusDao =new Learning_statusDao();
        //4.调用方法
        learning_statusDao.createLearning_status(learning_status);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
    public Learning_status selectById(int id){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        Learning_statusDao learning_statusDao =new Learning_statusDao();
        //4.调用方法
        Learning_status learning_status = learning_statusDao.selectById(id);
        sqlSession.close();
        return learning_status;
    }
    public void update(Learning_status learning_status){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个course-dao对象
        Learning_statusDao learning_statusDao =new Learning_statusDao();
        //4.调用方法
        learning_statusDao.update(learning_status);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
    public void delete(int id){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        Learning_statusDao learning_statusDao =new Learning_statusDao();
        //4.调用方法
        learning_statusDao.delete(id);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
}
