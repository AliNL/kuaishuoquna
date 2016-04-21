<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" scope="request" value="Home"/>
<%@ include file="header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" %>

<div id="home-form">
	<div class="home-bar red">
		<a href="<c:url value='/event/create' />">创建</a>
	</div>
	<div class="home-bar blue">
		<input id="event_name" type="text">
		<button id="join">加入</button>
	</div>
</div>

<%@ include file="footer.jsp" %>
