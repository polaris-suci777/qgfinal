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
        <th>课程名字</th>
        <th>题目内容</th>
        <th>学生名字</th>
        <th>学生答案</th>
        <th>是否正确</th>
        <th>分数</th>
        <th>操作</th>
    </tr>


    <c:forEach items="${student_answers}" var="student_answer" varStatus="status">
        <tr align="center">
                <%--<td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td>${student_answer.course_name}</td>
            <td>${student_answer.content}</td>
            <td>${student_answer.student_name}</td>
            <td>${student_answer.answer}</td>
            <td>${student_answer.is_correct}</td>
            <td>${student_answer.grade}</td>

            <td>
                <a href="/final-demo4/student_answerSelectByIdServlet?id=${student_answer.id}">修改答案</a>
                    <%--                <a href="/final-demo4/studentDeleteServlet?id=${student_answer.id}">删除</a>--%>
            </td>
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