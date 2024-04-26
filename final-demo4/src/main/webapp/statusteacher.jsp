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
        <th>学生姓名</th>
        <th>章节</th>
        <th>学习状态</th>
        <th>操作</th>
    </tr>


    <c:forEach items="${learning_statuses}" var="learning_status" varStatus="status">
        <tr align="center">
                <%--<td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td>${learning_status.course_name}</td>
            <td>${learning_status.student_name}</td>
            <td>${learning_status.chapter}</td>
            <td>${learning_status.status}</td>

                <%--            <td><a href="studentSelectByIdServlet?id=${student.id}&method=${"teacher"}">修改</a>--%>
                    <td> <a href="learning_statusDeleteServlet?id=${learning_status.id}&course_name=${learning_status.course_name}&method=${"teacher"}">删除</a></td>
        </tr>
    </c:forEach>

</table>

<script>
    document.getElementById("return").onclick = function (){
        location.href = "loginteacher.jsp";
    }
</script>
</body>
</html>