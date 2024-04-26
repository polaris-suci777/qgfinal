<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>修改课程信息</title>
</head>
<body>
<h3>修改课程信息</h3>
<form action="/final-demo4/chapterUpdateServlet" method="post">

    <%--隐藏域，提交id--%>
    <input type="hidden" name="id" value="${chapter.id}">
    课程名称：<input name="chapter_name" value="${chapter.chapter_name}"><br>
    单元：<input name="unit" value="${chapter.unit}"><br>
    章节：<input name="lesson" value="${chapter.lesson}"><br>
    课程描述：<textarea rows="5" cols="20" name="description">${chapter.description} </textarea><br>
    <input type="submit" value="提交">
</form>
</body>
</html>