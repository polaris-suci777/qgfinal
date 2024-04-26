package com.itheima.service;
import com.itheima.dao.SelectCourseDao;
import com.itheima.dao.message.CourseDao;
import com.itheima.dao.message.StudentDao;
import com.itheima.dao.message.TeacherDao;
import com.itheima.pojo.Enrollment;
import com.itheima.pojo.Student;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.itheima.pojo.Course;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectCourseService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
//        public boolean enrollStudent(String course_name,String student_name) throws SQLException {
//            //2. 获取SqlSession
//            SqlSession sqlSession = factory.openSession();
//            CourseDao courseDao = new CourseDao();
//            StudentDao studentDao =new StudentDao();
//            SelectCourseDao selectCourseDao = new SelectCourseDao();
//            Student student;
//            Course course;
//            course=courseDao.selectByName(course_name);
//            List<String>enrolledStudents = selectCourseDao.enrollmentStudents(course_name);
//            course.setEnrolledStudents(enrolledStudents);
//            student=studentDao.selectBynName(student_name);
//            if(student !=null) {
//                // 选课失败，课程容量已满
//                return enrolledStudents.size() < course.getEnrollmentlimit(); // 选课成功
//            }
//            else {
//                return false;
//            }
//        }

    public void addSelectCourse(String course_name, String student_name) throws SQLException {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        SelectCourseDao selectCourseDao = new SelectCourseDao();
//            if(enrollStudent(course_name,student_name)){
        selectCourseDao.addEnrollment(course_name, student_name);
  //  }
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }

    public List<Enrollment> showStudent(String course_name){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        SelectCourseDao selectCourseDao = new SelectCourseDao();
        List<Enrollment> enrollments;
        try {
            enrollments=selectCourseDao.showStudent(course_name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //释放资源
        sqlSession.close();
        return enrollments;
    }
    public List<Enrollment> showSelectCourse(String student_name){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        SelectCourseDao selectCourseDao = new SelectCourseDao();
        List<Enrollment> enrollments;
        try {
            enrollments=selectCourseDao.showSelectCourse(student_name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //释放资源
        sqlSession.close();
        return enrollments;
    }
    public String selectByStudent_name(String student_name){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        SelectCourseDao selectCourseDao = new SelectCourseDao();
        String course_name;
        try {
            course_name = selectCourseDao.selectByStudent_name(student_name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //释放资源
        sqlSession.close();
        return course_name;
    }

    public void delete(int id){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        SelectCourseDao selectCourseDao=new SelectCourseDao();
        //4.调用方法
        selectCourseDao.delete(id);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    public Enrollment selectById(int id){
        //调用BrandMapper.selectAll()
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.新建一个teacher-dao对象
        SelectCourseDao selectCourseDao=new SelectCourseDao();
        //4.调用方法
        Enrollment enrollment= selectCourseDao.selectById(id);

        sqlSession.close();

        return enrollment;
    }
    public List<Enrollment> selectall(){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        SelectCourseDao selectCourseDao = new SelectCourseDao();
        List<Enrollment> enrollments;
        try {
            enrollments=selectCourseDao.selectall();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //释放资源
        sqlSession.close();
        return enrollments;
    }

}


