<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>添加学生评论</title>

</head>
<body>
<input type="button" value="返回登录界面" id="add"><br>
<h3>添加学生评论</h3>
<form action="/final-demo4/discussionAddServlet" method="post">
    课程名称：<input name="course_name"><br>
    学生评论：<textarea rows="5" cols="20" name="student_discussion"></textarea><br>
    <input type="submit" value="提交">
</form>
<script>
    document.getElementById("add").onclick = function (){
        location.href = "loginstudent.jsp";
    }

</script>
</body>
</html>