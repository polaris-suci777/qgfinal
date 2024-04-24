<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>添加课程</title>
</head>
<body>
<h3>添加课程</h3>
<form action="/final-demo2/chapterAddServlet" method="post">
    课程名称：<input name="course_name"><br>
    单元：<input name="unit"><br>
    章节：<input name="lesson"><br>
    课程描述：<textarea rows="5" cols="20" name="description"></textarea><br>
    <input type="submit" value="提交">
</form>
</body>
</html>