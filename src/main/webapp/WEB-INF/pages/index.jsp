<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" scope="request" value="Home"/>
<%@ include file="header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" %>

${message}
	<h1>${message}</h1>
一些中文

<button id="create">创建</button>


<%@ include file="footer.jsp" %>
