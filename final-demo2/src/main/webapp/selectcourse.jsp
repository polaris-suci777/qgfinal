<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>选择课程</title>
</head>
<body>
<h3>选择课程信息</h3>
<form action="/final-demo2/selectCourseServlet" method="post">
    课程名称：<input name="course_name" ><br>
    学生名称：<input name="student_name" ><br>
            <input type="submit" value="提交">
</form>
</body>
</html>