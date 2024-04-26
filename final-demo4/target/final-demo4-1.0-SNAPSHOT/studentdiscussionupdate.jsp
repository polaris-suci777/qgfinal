<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改学生信息</title>
</head>
<body>
<h3>修改学生信息</h3>
<form action="/final-demo4/discussionUpdateByStudentServlet" method="post">
    <%--隐藏域，提交id--%>
    <input type="hidden" name="id" value="${discussion.id}">
    课程名字：<input name="course_name" value="${discussion.course_name}"><br>
    学生评论：<input name="student_discussion" value="${discussion.student_discussion}"><br>
    <input type="hidden" name="teacher_discussion" value="${discussion.teacher_discussion}"><br>
    <input type="submit" name="method" value="提交">
</form>
</body>
</html>