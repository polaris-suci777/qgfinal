<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改信息</title>
</head>
<body>
<input type="button" value="返回登录界面" id="return"><br>
<h3>修改信息</h3>
<form action="/final-demo4/discussionUpdateServlet" method="post">
    <%--隐藏域，提交id--%>
    <input type="hidden" name="id" value="${discussion.id}">
    课程名称：<input name="course_name" value="${discussion.course_name}">
    学生评论：<textarea rows="5" cols="20" name="student_discussion">${discussion.student_discussion} </textarea><br>
    老师回复：<textarea rows="5" cols="20" name="teacher_discussion">${discussion.teacher_discussion} </textarea><br>
    <input type="submit" name="method" value="${"manager"}">
</form>
<script>
    document.getElementById("return").onclick = function (){
        location.href = "loginmanager.jsp";
    }
</script>
</body>
</html>