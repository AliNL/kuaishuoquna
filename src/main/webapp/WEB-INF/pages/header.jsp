<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${pageTitle}</title>
    <link rel="stylesheet" href="<c:url value='/css/main.css' />" type="text/css"/>
</head>
<body>
<nav>
    <img src="<c:url value='/images/logo.png' />" alt="LOGO">
    <div id="isLoggedIn">
        <h2>Welcome !</h2>
        <a id="logOut" href="<c:url value='/' />"><h2>Log out</h2></a>
    </div>
</nav>
