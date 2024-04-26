<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>判断题目是否正确</title>
</head>
<body>
<h3>判断题目是否正确</h3>
<form action="/final-demo4/student_answerUpdateServlet" method="post">
    <input type="hidden" name="id" value="${student_answer.id}">
    <input type="hidden" name="course_name" value="${student_answer.course_name}">
    <input type="hidden" name="content" value="${student_answer.content}">
    <input type="hidden" name="student_name" value="${student_answer.student_name}">
    <input type="hidden" name="answer" value="${student_answer.answer}">
    是否正确：<input name="is_correct" value="${student_answer.is_correct}">
    打分：<input name="grade" value="${student_answer.grade}">
    <input type="submit" value="提交">
</form>
</body>
</html>