<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv" style="height: 350px">
    <form action="/final-demo4/loginServlet" method="post" id="form">
        <h1 id="loginMsg">LOGIN IN</h1>
        <div id="errorMsg">${login_msg} ${register_msg}</div>
        <p>Username:<input id="username" name="name"  type="text"></p>

        <p>Password:<input id="password" name="password"  type="password"></p>
        <table>
        <tr class="radio-row">
            <td>
                <input type=radio name=type value=teacher id="teacherRadio">
                <label for="teacherRadio">教师</label>
                <input type=radio name=type value=student id="studentRadio" checked>
                <label for="studentRadio">学生</label>
                <input type=radio name=type value=manager id="managerRadio" checked>
                <label for="managerRadio">管理员</label>
            </td>
        </tr>
        </table>
        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
            <a href="register.jsp">没有账号？立即注册！</a>
        </div>
    </form>
</div>



</body>
</html>