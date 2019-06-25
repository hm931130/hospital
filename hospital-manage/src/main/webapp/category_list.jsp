<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <title>科室列表</title>
    <link rel="stylesheet" type="text/css" href="../css/index.css"/>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
</head>

<body>
<header>
    <div class="container">


        <c:forEach items="${CLIST}" var="category">

            <nav>
                <a href="../dept/list.do?cid=${category.id}">${category.name}</a>
            </nav>

        </c:forEach>
        <nav>
            <a href="list.do">分类</a>
        </nav>
        <nav>
            <a href="../logout.do">退出登录</a>
        </nav>

    </div>
</header>
<section class="banner">
    <div class="container">
        <div>
            <h1>科室</h1>
            <p>科室分类列表</p>
        </div>
    </div>
</section>
<section class="main">
    <div class="container">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>名称</th>
                <th>创建时间</th>
                <th>最后修改时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${CLIST}" var="category">
                <tr>
                    <td>${category.name}</td>
                    <td><fmt:formatDate value="${category.createTime}" pattern="yyyy-MM-dd hh:mm"/></td>
                    <td><fmt:formatDate value="${category.updateTime}" pattern="yyyy-MM-dd hh:mm"/></td>
                    <td>
                        <a href="toEdit.do?id=${category.id}">修改</a>&nbsp;&nbsp;
                        <a href="delete.do?id=${category.id}">删除</a>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<section class="page">
    <div class="container">
        <div id="fatie">
            <a href="toAdd.do">
                <button>新建</button>
            </a>
        </div>
    </div>
</section>
<footer>
    copy@慕课网
</footer>
</body>
</html>