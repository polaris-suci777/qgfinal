<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%--<input type="button" value="新增" id="add"><br>--%>
<input type="button" value="返回登录界面" id="return"><br>
<hr>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>课程名称</th>
        <th>学生评论</th>
        <th>老师回复</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${discussions}" var="discussion" varStatus="status">
        <tr align="center">
                <%--<td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td>${discussion.course_name}</td>
            <td>${discussion.student_discussion}</td>
            <td>${discussion.teacher_discussion}</td>
            <td>
                <a href="/final-demo4/discussionDeleteServlet?id=${discussion.id}">&method=${"student"}删除</a>
                <a href="/final-demo4/studentdiscussionupdate.jsp?id=${discussion.id}">修改</a>
<%--                <a href="/final-demo4/chapterSelectAllServlet?&name=${discussion.name}">查看章节</a></td>--%>
        </tr>

    </c:forEach>

</table>

<script>
    // document.getElementById("add").onclick = function (){
    //     location.href = "adddiscussion.jsp";
    // }
    document.getElementById("return").onclick = function (){
        location.href = "loginstudent.jsp";
    }

</script>
</body>
</html>