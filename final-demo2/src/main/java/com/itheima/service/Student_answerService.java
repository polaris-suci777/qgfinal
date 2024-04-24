package com.itheima.service;

import com.itheima.dao.Student_answerDao;
import com.itheima.dao.message.StudentDao;
import com.itheima.pojo.Student;
import com.itheima.pojo.Student_answer;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class Student_answerService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Student_answer> selectAll() throws SQLException {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个course-dao对象
        Student_answerDao student_answerDao =new Student_answerDao();
        //4.调用方法
        List<Student_answer> student_answers = student_answerDao.SelectAll();
        return student_answers;
    }
    public void add(Student_answer student_answer) throws Exception {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        Student_answerDao student_answerDao =new Student_answerDao();
        //4.调用方法
        student_answerDao.createStudent_answer(student_answer);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
    public Student_answer selectById(int id){
        //调用BrandMapper.selectAll()
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        Student_answerDao student_answerDao =new Student_answerDao();
        //4.调用方法
        Student_answer student_answer = student_answerDao.selectById(id);

        sqlSession.close();
        return student_answer;
    }
    public void update(Student_answer student_answer){

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个course-dao对象
        Student_answerDao student_answerDao =new Student_answerDao();
        //4.调用方法
        student_answerDao.update(student_answer);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
    public void delete(int id){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        Student_answerDao student_answerDao =new Student_answerDao();
        //4.调用方法
        student_answerDao.delete(id);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

}
