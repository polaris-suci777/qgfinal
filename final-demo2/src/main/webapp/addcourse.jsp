<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>添加课程</title>

</head>
<body>
<input type="button" value="返回登录界面" id="add"><br>
<h3>添加课程</h3>
<form action="/final-demo2/courseAddServlet" method="post">
    课程名称：<input name="name"><br>
    课程描述：<textarea rows="5" cols="20" name="description"></textarea><br>
    开始日期：<input name="startdate"><br>
    结束日期：<input name="enddate"><br>
    限制学生人数：<input name="enrollmentlimit"><br>
    <input type="submit" value="提交">
</form>
<script>
    document.getElementById("add").onclick = function (){
        location.href = "loginteacher.jsp";
    }

</script>
</body>
</html>