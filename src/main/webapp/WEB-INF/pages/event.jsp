<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" scope="request" value="Event"/>
<%@ include file="header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%--<c:if test="${eventDetail.active}">--%>
	<p>${eventDetial.name}</p>
	<p>${eventDetial.owner}</p>
	<p>${eventDetial.description}</p>
<%--</c:if>--%>
<%@ include file="footer.jsp" %>
