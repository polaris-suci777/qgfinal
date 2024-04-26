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
<input type="button" value="返回登录界面" id="return"><br>
<hr>
<table border="1" cellspacing="0" width="80%">
  <tr>
    <th>序号</th>
    <th>学生名字</th>
    <th>密码</th>
    <th>学号</th>
    <th>年级</th>
    <th>个人介绍</th>
    <th>性别</th>
    <th>操作</th>
  </tr>


  <c:forEach items="${students}" var="student" varStatus="status">
    <tr align="center">
        <%--<td>${brand.id}</td>--%>
      <td>${status.count}</td>
      <td>${student.name}</td>
      <td>${student.password}</td>
      <td>${student.studentnumber}</td>
      <td>${student.grade}</td>
      <td>${student.introduction}</td>
      <td>${student.sex}</td>

      <td><a href="studentSelectByIdServlet?id=${student.id}&method=${"manager"}">修改</a>
        <a href="studentDeleteServlet?id=${student.id}&method=${"manager"}">删除</a></td>
    </tr>
  </c:forEach>

</table>

<script>
  document.getElementById("add").onclick = function (){
    location.href = "manageraddstudent.jsp";
  }
  document.getElementById("return").onclick = function (){
    location.href = "loginmanager.jsp";
  }
</script>
</body>
</html>