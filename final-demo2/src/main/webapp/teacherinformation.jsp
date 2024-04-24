<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<input type="button" value="返回登录界面" id="add"><br>
<hr>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>老师名称</th>
        <th>邮箱</th>
        <th>qq号码</th>
        <th>科目</th>
        <th>个人介绍</th>
        <th>操作</th>
    </tr>
    <tr align="center">
        <%--<td>${brand.id}</td>--%>
        <td>${teacher.id}</td>
        <td>${teacher.name}</td>
        <td>${teacher.email}</td>
        <td>${teacher.qq}</td>
        <td>${teacher.subject}</td>
        <td>${teacher.introduction}</td>
        <td><a href="/final-demo2/teacherSelectByIdServlet?id=${teacher.id}">修改</a>
            <a href="/final-demo2/teacherDeleteServlet?id=${teacher.id}">删除</a>
            <a href="/final-demo2/teacherpasswordupdate.jsp?id=${teacher}">修改密码</a>
        </td>
    </tr>
    <script>
        document.getElementById("add").onclick = function (){
            location.href = "loginteacher.jsp";
        }

    </script>


</table>
</body>
</html>