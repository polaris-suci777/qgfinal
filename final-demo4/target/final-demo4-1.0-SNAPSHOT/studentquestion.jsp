<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <th>题目类型</th>
        <th>题目内容</th>
        <th>选择项A</th>
        <th>选择项B</th>
        <th>选择项C</th>
        <th>选择项D</th>
        <th>操作</th>
    </tr>


    <c:forEach items="${questions}" var="question" varStatus="status">
        <tr align="center">
                <%--<td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td>${question.course_name}</td>
            <td>${question.type}</td>
            <td>${question.content}</td>
            <td>${question.choiceA}</td>
            <td>${question.choiceB}</td>
            <td>${question.choiceC}</td>
            <td>${question.choiceD}</td>
            <td><a href="addstudent_answer.jsp?content=${question.content}&course_name=${question.course_name}">回答题目</a>
<%--                <a href="/final-demo4/questionDeleteServlet?id=${question.id}">删除</a>--%>

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