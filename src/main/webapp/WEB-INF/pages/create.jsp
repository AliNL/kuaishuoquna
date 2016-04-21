<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" scope="request" value="Create"/>
<%@ include file="header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" %>


<form id="register_form" action="/event/submit" method="post">

    <div id="name_field">
        <label for="fld_name">Name</label>
        <input type="text" id="fld_name" placeholder="Event Name" name="name">
    </div>

    <div id="password_field">
        <label for="fld_password">Password</label>
        <input type="password" id="fld_password" placeholder="Password" name="password">
    </div>

    <div id="description_field">
        <label for="fld_description">description</label>
        <input type="text" id="fld_description" name="description">
    </div>

    <div id="owner_field">
        <label for="fld_owner">owner</label>
        <input type="text" id="fld_owner" name="owner">
    </div>


    <div>
            <input type="submit" id="createEvent" value="Create Event">
    </div>

</form>


<%@ include file="footer.jsp" %>