<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学习平台学生前端界面</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        nav {
            background-color: #f4f4f4;
            padding: 10px;
        }

        nav ul {
            list-style-type: none;
            padding: 0;
        }

        nav ul li {
            display: inline-block;
            margin-right: 10px;
        }

        nav ul li a {
            color: #333;
            text-decoration: none;
        }

        section {
            padding: 20px;
        }

        footer {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
        }
    </style>
</head>
<body>
<header>
    <h1>学习平台学生前端界面</h1>
</header>
<nav>
    <ul>
        <li><a href="courseSelectAllServlet?method=${"student"}">选择课程</a></li>
        <li><a href="courseSelectAllServlet">浏览课程</a></li>
        <li><a href="studentSelectAllServlet">学生管理</a></li>
        <li><a href="studentSelectAllServlet?method=${"student"}">修改信息</a></li>
        <li><a href="selectAllSelectCourseServlet?student_name=${student.name}">查看已报名课程</a></li>
    </ul>
</nav>

<section>
    <h2>欢迎${student.name}老师！</h2>
    <p>在这里，您可以管理您的课程、学生、作业和考试等。请根据您的需求选择相应的功能进行操作。</p>

    <!-- 这里可以添加更多内容，如课程列表、学生列表等 -->
</section>

</body>
</html>