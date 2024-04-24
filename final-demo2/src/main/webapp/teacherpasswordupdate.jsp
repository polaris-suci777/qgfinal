<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>修改信息</title>
</head>
<body>
<h3>修改信息</h3>
<form action="/final-demo2/teacherUpdateServlet" method="post">

    <%--隐藏域，提交id--%>
    <input type="hidden" name="id" value="${teacher.id}">
    <input type="hidden" name="name" value="${teacher.name}"><br>
    密码：<input name="password" value="${teacher.password}"><br>
    <input type="hidden" name="email" value="${teacher.email}"><br>
    <input type="hidden" name="qq" value="${teacher.qq}"><br>
    <input type="hidden" name="subject" value="${teacher.subject}"><br>
    <input type="hidden" name="introduction" value="${teacher.introduction}"> <br>
    <input type="submit" name="method" value="${"passwordsubmit"}">
</form>
</body>
</html>