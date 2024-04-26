<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<input type="button" value="新增" id="add"><br>
<hr>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>学生名字</th>
        <th>学号</th>
        <th>年级</th>
        <th>个人介绍</th>
        <th>性别</th>
        <th>操作</th>
    </tr>
    <tr align="center">
        <%--<td>${brand.id}</td>--%>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.studentnumber}</td>
        <td>${student.grade}</td>
        <td>${student.introduction}</td>
        <td>${student.sex}</td>
        <td><a href="/final-demo4/studentSelectByIdServlet?id=${student.id}&method=${"student"}">修改</a>
            <a href="/final-demo4/studentpasswordupdate.jsp?id=${student.id}&method=${"student"}">修改密码</a>
        </td>
    </tr>

</table>


</body>
</html>
