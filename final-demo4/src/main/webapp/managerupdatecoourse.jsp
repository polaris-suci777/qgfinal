<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>修改课程信息</title>
</head>
<body>
<input type="button" value="返回登录界面" id="return"><br>
<h3>修改课程信息</h3>
<form action="/final-demo4/courseUpdateServlet" method="post">

    <%--隐藏域，提交id--%>
    <input type="hidden" name="id" value="${course.id}">
    课程名称：<input name="name" value="${course.name}"><br>
    课程描述：<textarea rows="5" cols="20" name="description">${course.description} </textarea><br>
    开始日期：<input name="startdate" value="${course.startdate}"><br>
    结束日期：<input name="enddate" value="${course.enddate}"><br>
    学生人数限制：<input name="enrollmentlimit" value="${course.enrollmentlimit}"><br>
    <input type="submit" name="method" value="${"manager"}">
</form>
<script>
    document.getElementById("return").onclick = function (){
        location.href = "loginmanager.jsp";
    }
</script>
</body>
</html>