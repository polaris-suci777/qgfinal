package com.itheima.service;

import com.itheima.dao.LoginDao;
import com.itheima.pojo.Manager;
import com.itheima.pojo.Student;
import com.itheima.pojo.Teacher;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;

public class LoginService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public Teacher teacherSelect(String name, String password) throws SQLException {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.获取一个LoginDao对象
        LoginDao logindao = new LoginDao();
        //4.调用方法
        Teacher teacher;
        teacher = logindao.teacherSelect(name, password);
        //释放资源
        sqlSession.close();
        return teacher;
    }

    public Student studentSelect(String name, String password) throws SQLException {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.获取一个LoginDao对象
        LoginDao logindao = new LoginDao();
        //4.调用方法
        Student student;
        student = logindao.studentSelect(name, password);
        //释放资源
        sqlSession.close();
        return student;
    }
    public Manager managerSelect(String name, String password) throws SQLException {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.获取一个LoginDao对象
        LoginDao logindao = new LoginDao();
        //4.调用方法
        Manager manager;
        manager = logindao.managerSelect(name, password);
        //释放资源
        sqlSession.close();
        return manager;
    }
}