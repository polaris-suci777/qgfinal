<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>修改教师信息</title>
</head>
<body>
<input type="button" value="返回登录界面" id="return"><br>
<h3>修改教师信息</h3>
<form action="/final-demo4/teacherUpdateServlet" method="post">

    <%--隐藏域，提交id--%>
    <input type="hidden" name="id" value="${teacher.id}">
    老师名称：<input name="name" value="${teacher.name}"><br>
    老师密码： <input  name="password" value="${teacher.password}"><br>
    邮箱：<input name="email" value="${teacher.email}"><br>
    qq：<input name="qq" value="${teacher.qq}"><br>
    科目：<input name="subject" value="${teacher.subject}"><br>
    自我介绍：<textarea rows="5" cols="20" name="introduction">${teacher.introduction} </textarea><br>
    <input type="submit" name="method" value="${"manager"}">
</form>
<script>
    document.getElementById("return").onclick = function (){
        location.href = "loginmanager.jsp";
    }
</script>
</body>
</html>