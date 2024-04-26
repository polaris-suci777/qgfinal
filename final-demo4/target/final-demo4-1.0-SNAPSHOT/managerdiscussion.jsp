
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
</body>
</html>
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
        <th>学生评论</th>
        <th>老师回复</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${discussions}" var="discussion" varStatus="status">
        <tr align="center">
                <%--<td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td>${discussion.course_name}</td>
            <td>${discussion.student_discussion}</td>
            <td>${discussion.teacher_discussion}</td>
            <td><a href="/final-demo4/discussionSelectByIdServlet?id=${discussion.id}&method=${"manager"}">修改评论</a>
                <a href="/final-demo4/discussionDeleteServlet?id=${discussion.id}&method=${"manager"}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<script>
    document.getElementById("return").onclick = function (){
        location.href = "loginmanager.jsp";
    }
</script>
</body>
</html>