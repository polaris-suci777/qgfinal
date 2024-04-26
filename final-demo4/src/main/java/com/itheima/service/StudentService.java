package com.itheima.service;

import com.itheima.dao.message.StudentDao;
import com.itheima.pojo.Student;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    /**
     * 查询所有
     * @return
     */
    public List<Student> selectAll() throws SQLException {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个course-dao对象
        StudentDao studentDao =new StudentDao();
        //4.调用方法
        List<Student> students = studentDao.SelectAll();
        return students;
    }

    /**
     * 添加
     * @param student
     */
    public void add(Student student) throws Exception {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        StudentDao studentDao =new StudentDao();
        //4.调用方法
        studentDao.createStudent(student);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }



    /**
     * 根据id查询
     * @return
     */
    public Student selectById(int id){
        //调用BrandMapper.selectAll()
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        StudentDao studentDao =new StudentDao();
        //4.调用方法
        Student student = studentDao.selectById(id);

        sqlSession.close();
        return student;
    }


    /**
     * 修改
     * @param student
     */
    public void update(Student student){

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();

        //3.新建一个course-dao对象
        StudentDao studentDao =new StudentDao();
        //4.调用方法
        studentDao.update(student);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }
    public void delete(int id){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        StudentDao studentDao =new StudentDao();
        //4.调用方法
        studentDao.delete(id);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

}
