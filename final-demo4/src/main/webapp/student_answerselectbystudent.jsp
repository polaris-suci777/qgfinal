<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>查看题目</title>
</head>
<body>
<h3>查看题目</h3>
<form action="/final-demo4/student_answerSelectAllServlet" method="post">

    <%--隐藏域，提交id--%>
    <input type="hidden" name="id" value="${student_answer.id}">
    要查看哪个课程的作答：<input name="course_name" ><br>
    <input type="hidden" name="method" value="student"><br>
    <input type="submit" name="type" value="提交">
</form>
</body>
</html>