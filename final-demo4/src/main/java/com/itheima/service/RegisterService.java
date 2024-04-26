package com.itheima.service;

import com.itheima.dao.RegisterDao;
import com.itheima.dao.message.TeacherDao;
import com.itheima.pojo.Manager;
import com.itheima.pojo.Student;
import com.itheima.pojo.Teacher;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class RegisterService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public boolean registerTeacher(Teacher teacher) throws Exception {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        RegisterDao registerDao = new RegisterDao();
        Teacher t = registerDao.selectByTeacherName(teacher.getName());
        //4.调用方法
        if(t==null){
        registerDao.registerTeacher(teacher);
        //提交事务
        sqlSession.commit();
            return true;}
        //释放资源
        sqlSession.close();
        return false;
    }
    public boolean registerStudent(Student student) throws Exception {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        RegisterDao registerDao = new RegisterDao();
        Student s = registerDao.selectByStudentName(student.getName());
        //4.调用方法
        if(s==null){
        registerDao.registerStudent(student);
        //提交事务
        sqlSession.commit();
        return true;}
        //释放资源
        sqlSession.close();
        return false;
    }
    public boolean registerManager(Manager manager) throws Exception {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        RegisterDao registerDao = new RegisterDao();
        Manager m = registerDao.selectByManagerName(manager.getName());
        //4.调用方法
        if(m==null){
            registerDao.registerManager(manager);
            //提交事务
            sqlSession.commit();
            return true;}
        //释放资源
        sqlSession.close();
        return false;
    }
}
