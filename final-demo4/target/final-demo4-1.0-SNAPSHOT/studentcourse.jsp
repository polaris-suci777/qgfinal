<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>查看报名学生情况</title>
</head>
<body>
<h3>查看报名学生情况</h3>
<form action="/final-demo4/showStudentServlet" method="post">
    需查找的课程名称：<input name="course_name" ><br>
    <input type="submit" value="提交">
</form>
</body>
</html>