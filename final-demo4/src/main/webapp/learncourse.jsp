<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<input type="button" value="返回登录界面" id="return"><br>
<hr>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>课程名称</th>
        <th>课程描述</th>
        <th>开始日期</th>
        <th>结束日期</th>
        <th>学生人数限制</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${courses}" var="course" varStatus="status">
        <tr align="center">
                <%--<td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td>${course.name}</td>
            <td>${course.description}</td>
            <td>${course.startdate}</td>
            <td>${course.enddate}</td>
            <td>${course.enrollmentlimit}</td>
            <td><a href="/final-demo4/learnChapterServlet?&course_name=${course.name}">学习章节</a></td>
        </tr>
    </c:forEach>
</table>
<script>
    document.getElementById("return").onclick = function (){
        location.href = "loginstudent.jsp";
    }
</script>
</body>
</html>