package com.itheima.service;

import com.itheima.dao.message.TeacherDao;
import com.itheima.pojo.Teacher;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class TeacherService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    /**
     * 查询所有
     * @return
     */
    public List<Teacher> selectAll() throws SQLException {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        TeacherDao teacherDao=new TeacherDao();
        //4.调用方法
        List<Teacher> teachers=teacherDao.SelectAll();
        return teachers;
    }

    /**
     * 添加
     * @param teacher
     */
    public void add(Teacher teacher) throws Exception {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        TeacherDao teacherDao=new TeacherDao();
        //4.调用方法
        teacherDao.createTeacher(teacher);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }



    /**
     * 根据id查询
     * @return
     */
    public Teacher selectById(int id){
        //调用BrandMapper.selectAll()
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        TeacherDao teacherDao=new TeacherDao();
        //4.调用方法
        Teacher teacher=teacherDao.selectById(id);

        sqlSession.close();
        return teacher;
    }


    /**
     * 修改
     * @param teacher
     */
    public void update(Teacher teacher){

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();

        //3.新建一个teacher-dao对象
        TeacherDao teacherDao=new TeacherDao();
        //4.调用方法
        teacherDao.update(teacher);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }
    public void delete(int id){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        TeacherDao teacherDao=new TeacherDao();
        //4.调用方法
        teacherDao.delete(id);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

}
