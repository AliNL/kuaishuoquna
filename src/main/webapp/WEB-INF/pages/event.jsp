<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" scope="request" value="Event"/>
<%@ include file="header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%--<c:if test="${eventDetail.active}">--%>
	<p>${eventDetail.name}</p>
	<p>${eventDetail.owner}</p>
	<p>${eventDetail.description}</p>
<%--</c:if>--%>
<%@ include file="footer.jsp" %>
