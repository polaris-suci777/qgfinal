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
<form action="/final-demo4/discussionUpdateServlet" method="post">

    <%--隐藏域，提交id--%>
    <input type="hidden" name="id" value="${discussion.id}">
    <input type="hidden" name="course_name" value="${discussion.course_name}">
    <input type="hidden" name="student_discussion" value="${discussion.student_discussion}"><br>
    回复信件：<textarea rows="5" cols="20" name="teacher_discussion">${discussion.teacher_discussion} </textarea><br>
    <input type="submit" value="提交">
</form>
</body>
</html>