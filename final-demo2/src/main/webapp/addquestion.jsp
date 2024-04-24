<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>添加题目</title>
</head>
<body>
<input type="button" value="返回登录界面" id="add"><br>
<h3>添加题目</h3>
<form action="/final-demo2/questionAddServlet" method="post">
    课程名称：<input name="course_name"><br>
    题目类型：<input name="type"><br>
    题目内容：<textarea rows="5" cols="20" name="content"></textarea>><br>
    选择项A：<input name="choiceA"><br>
    选择项B：<input name="choiceB"><br>
    选择项C：<input name="choiceC"><br>
    选择项D：<input name="choiceD"><br>
    答案：<input name="answer"><br>
    <input type="submit" value="提交">
</form>
<script>
    document.getElementById("add").onclick = function (){
        location.href = "loginteacher.jsp";
    }
</script>
</body>
</html>