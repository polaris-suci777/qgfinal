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
    <th>课程名称</th>
    <th>学生名称</th>
    <th>操作</th>
  </tr>


  <c:forEach items="${enrollments}" var="enrollment" varStatus="status">
    <tr align="center">
        <%--<td>${brand.id}</td>--%>
      <td>${status.count}</td>
      <td>${enrollment.course_name}</td>
      <td>${enrollment.student_name}</td>
          <td>
            <a href="/enrollmentSelectByIdServlet?id=${enrollment.id}">修改</a>
            <a href="/enrollmentDeleteServlet?id=${enrollment.id}">删除</a></td>
    </tr>


  </c:forEach>

</table>

<script>
  document.getElementById("add").onclick = function (){
    location.href = "selectcourse.jsp";
  }
  document.getElementById("return").onclick = function (){
    location.href = "loginstudent.jsp";
  }

</script>
</body>
</html>