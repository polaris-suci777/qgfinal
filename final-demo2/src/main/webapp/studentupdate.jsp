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
<form action="/final-demo2/studentUpdateServlet" method="post">

    <%--隐藏域，提交id--%>
    <input type="hidden" name="id" value="${student.id}">
    学生名字：<input name="name" value="${student.name}"><br>
<%--    学生密码：<input name="password" value="${student.password}"><br>--%>
    学生学号：<input name="studentnumber" value="${student.studentnumber}"><br>
    学生年级：<input name="grade" value="${student.grade}"><br>
    个人介绍：<textarea rows="5" cols="20" name="description">${student.introduction} </textarea><br>
    性别：<input name="sex" value="${student.sex}"><br>
    <input type="submit" name="type" value="${student}">
</form>
</body>
</html>