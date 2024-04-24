<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>添加品牌</title>
</head>
<body>
<h3>添加品牌</h3>
<form action="/final-demo2/teacherAddServlet" method="post">
    老师姓名：<input name="name"><br>
    注册密码：<input name="password"><br>
    邮箱：<input name="email"><br>
    qq：<input name="qq"><br>
    科目：<input name="subject"><br>
    个人介绍：<textarea rows="5" cols="20" name="introduciton"></textarea><br>
    <input type="submit" value="提交">
</form>
</body>
</html>