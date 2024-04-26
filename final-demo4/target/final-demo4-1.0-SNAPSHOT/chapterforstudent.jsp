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
        <th>单元</th>
        <th>章节</th>
        <th>描述</th>
<%--        <th>操作</th>--%>
    </tr>


    <c:forEach items="${chapters}" var="chapter" varStatus="status">
        <tr align="center">
                <%--<td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td>${chapter.course_name}</td>
            <td>${chapter.unit}</td>
            <td>${chapter.lesson}</td>
            <td>${chapter.description}</td>

<%--            <td><a href="/final-demo4/chapterSelectByIdServlet?id=${chapter.id}">修改</a>--%>
<%--                <a href="/final-demo4/selectchapterServlet?id=${chapter.id}">选择</a>--%>
<%--                <a href="/final-demo4/chapterDeleteServlet?id=${chapter.id}">删除</a></td>--%>
<%--        </tr>--%>

    </c:forEach>

</table>

<script>
    // document.getElementById("add").onclick = function (){
    //     location.href = "addchapter.jsp";
    // }
    document.getElementById("return").onclick = function (){
        location.href = "loginstudent.jsp";
    }


</script>
</body>
</html>