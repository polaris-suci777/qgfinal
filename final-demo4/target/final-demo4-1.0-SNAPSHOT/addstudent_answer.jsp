<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>回答题目</title>
</head>
<body>
<h3>回答题目</h3>

<%
        request.setCharacterEncoding("utf-8");
        // 获取content参数
        String content = request.getParameter("content");
        // 获取course_name参数
        String course_name = request.getParameter("course_name");
%>



<form action="/final-demo4/student_answerAddServlet" method="post">
    <input type="hidden" name="course_name" value="<%= course_name %>"><br>
    <input type="hidden" name="content" value="<%= content %>"><br>
    学生名字：<input name="student_name"><br>
    题目回答：<input name="answer"><br>
    <input type="hidden" name="is_correct"><br>
    <input type="hidden" name="grade"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>