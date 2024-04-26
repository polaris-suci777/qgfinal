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
            /* 其他样式 */
            margin: 0;
            padding: 0;
            background-image: url('imgs/Desert.jpg') ; /* 在这里插入您的图片URL */
            background-repeat: no-repeat; /* 不重复图片 */
            background-size: 500% 500%;
            background-position: center; /* 图片居中 */
        }
        body {
            margin: 0;
            padding: 0;
        }
        header {
            /*background-color: #333;*/
            background-color: #ADD8E6; /* 这里将背景色更改为天蓝色 */
            color: #fff;
            padding: 10px;
            text-align: center;
        }
        nav ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
            overflow: hidden;
            /*background-color: #333;*/
            background-color: #ADD8E6; /* 这里将背景色更改为天蓝色 */
        }
        /* 样式化列表项 */
        nav ul li {
            float: left;
        }
        /* 样式化链接 */
        nav ul li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        /* 鼠标悬停时链接变色 */
        nav ul li a:hover {
            background-color: #111;
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
        <li><a href="courseSelectAllServlet?&method=${"student"}">浏览课程</a></li>
        <li><a href="studentinformation.jsp">修改信息</a></li>
        <li><a href="enrollmentSelectAllServlet?student_name=${student.name}">查看已报名课程</a></li>
        <li><a href="questionselectbystudent.jsp">查看题目</a></li>
        <li><a href="student_answerselectbystudent.jsp">查看答题情况</a></li>
        <li><a href="adddiscussion.jsp">发表评论</a></li>
        <li><a href="discussionselectbystudent.jsp">查看评论区</a></li>
        <li><a href="/final-demo4/discussionSelectAllByStudentServlet">查看所有的评论区</a></li>
        <li><a href="index.jsp">返回登录界面</a></li>
    </ul>
</nav>

<section>
    <h2>欢迎${student.name}学生！今天的日期是${date}</h2>
    <p>在这里，您可以管理您的课程、学生、作业和考试等。请根据您的需求选择相应的功能进行操作。</p>

    <!-- 这里可以添加更多内容，如课程列表、学生列表等 -->
</section>

</body>
</html>