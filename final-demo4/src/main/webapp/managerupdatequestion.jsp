<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改信息</title>
</head>
<body>
<input type="button" value="返回登录界面" id="return"><br>
<h3>修改信息</h3>
<form action="/final-demo4/questionUpdateServlet" method="post">
    <%--隐藏域，提交id--%>
    <input type="hidden" name="id" value="${question.id}">
    课程名称：<input name="course_name" value="${question.course_name}"><br>
    题目类型: <input  name="type" value="${question.type}"><br>
    题目内容：<textarea rows="5" cols="20" name="content">${question.content} </textarea><br>
    选项A: <input  name="choiceA" value="${question.choiceA}"><br>
    选项B: <input  name="choiceB" value="${question.choiceB}"><br>
    选项C: <input  name="choiceC" value="${question.choiceC}"><br>
    选项D: <input  name="choiceD" value="${question.choiceD}"><br>
    题目答案: <input  name="answer" value="${question.answer}"><br>
    <input type="submit" name="method" value=${"manager"}>
</form>
<script>
    document.getElementById("return").onclick = function (){
        location.href = "loginmanager.jsp";
    }
</script>
</body>
</html>