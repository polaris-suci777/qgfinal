package com.itheima.service;

import com.itheima.dao.message.CourseDao;
import com.itheima.pojo.Course;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class CourseService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    /**
     * 查询所有
     * @return
     */
    public List<Course> selectAll() throws SQLException {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个course-dao对象
        CourseDao courseDao =new CourseDao();
        //4.调用方法
        List<Course> courses = courseDao.SelectAll();
        return courses;
    }

    public List<Course> selectAllByCourse_name(String course_name) throws SQLException {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个course-dao对象
        CourseDao courseDao =new CourseDao();
        //4.调用方法
        List<Course> courses = courseDao.SelectAllByCourse_name(course_name);
        return courses;
    }

    /**
     * 添加
     * @param course
     */
    public void add(Course course) throws Exception {

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        CourseDao courseDao =new CourseDao();
        //4.调用方法
        courseDao.createCourse(course);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }



    /**
     * 根据id查询
     * @return
     */
    public Course selectById(int id){
        //调用BrandMapper.selectAll()
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        CourseDao courseDao =new CourseDao();
        //4.调用方法
        Course course = courseDao.selectById(id);

        sqlSession.close();
        return course;
    }



    /**
     * 修改
     * @param course
     */
    public void update(Course course){

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();

        //3.新建一个course-dao对象
        CourseDao courseDao =new CourseDao();
        //4.调用方法
        courseDao.update(course);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }
    public void delete(int id){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        CourseDao courseDao=new CourseDao();
        //4.调用方法
        courseDao.delete(id);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

}
