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
<form action="/final-demo4/studentUpdateByStudentServlet" method="post">

    <%--隐藏域，提交id--%>
    <input type="hidden" name="id" value="${student.id}">
        <input type="hidden" name="name" value="${student.name}">
        学生密码：<input name="password" value="${student.password}"><br>
        <input type="hidden" name="studentnumber" value="${student.studentnumber}">
        <input type="hidden" name="grade" value="${student.grade}">
        <input type="hidden" name="introduction" value="${student.introduction}">
        <input type="hidden" name="sex" value="${student.sex}">
        <input type="submit" name="method" value=${"passwordsubmit"}>
</form>
</body>
</html>