<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>修改学生答案</title>
</head>
<body>
<h3>修改学生答案</h3>
<form action="/final-demo4/student_answerUpdateByStudentServlet" method="post">

    <%--隐藏域，提交id--%>
    <input type="hidden" name="id" value="${student_answer.id}">
    <input type="hidden" name="course_name" value="${student_answer.course_name}"><br>
    <input type="hidden" name="content" value="${student_answer.content}"><br>
    学生名字：<input name="student_name" value="${student_answer.student_name}"><br>
    学生答案：<input name="answer" value="${student_answer.answer}"><br>
    <input type="hidden" name="is_correct" value="${student_answer.is_correct}"><br>
    <input type="hidden" name="grade" value="${student_answer.grade}"><br>
    <input type="submit" name="method" value="提交">
</form>
</body>
</html>