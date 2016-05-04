<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" scope="request" value="Home"/>
<%@ include file="header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" %>

<div id="home-form">
    <a href="<c:url value='/event/create' />">创建</a>
</div>

<%@ include file="footer.jsp" %>
