<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>添加课程</title>
</head>
<body>
<h3>添加课程</h3>
<form action="/final-demo2/studentAddServlet" method="post">
    学生名字：<input name="name"><br>
    密码：<input name="password"><br>
    学号：<input name="studentnumber"><br>
    年级：<input name="grade"><br>
    自我介绍：<textarea rows="5" cols="20" name="introduction"></textarea><br>
    性别：<input name="sex"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>