<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${pageTitle}</title>
    <link rel="stylesheet" href="<c:url value='/css/main.css' />" type="text/css"/>
    <script type="text/javascript" src="<c:url value='/js/lib/jquery-1.10.2.js' />"></script>
    <script type="text/javascript" src="<c:url value='/js/lib/jquery.cookie.js' />"></script>
    <script type="text/javascript" src="<c:url value='/js/main.js' />"></script>
</head>
<body>
<nav>
    <img src="<c:url value='/images/logo.png' />" alt="LOGO">
    <a href="<c:url value='/event/create' />">创建</a>
    <a href="<c:url value='/' />">主页</a>
</nav>
