<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" scope="request" value="Create"/>
<%@ include file="header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" %>


<form id="register_form" action="/event/submit" method="post">

    <div id="name_field">
        <label for="fld_name">活动名称：</label>
        <input type="text" id="fld_name" placeholder="请输入活动名称" name="name">
    </div>

    <div id="description_field">
        <label for="fld_description">活动描述：</label>
        <textarea id="fld_description" name="description"></textarea>
    </div>

    <div id="owner_field">
        <label for="fld_owner">组织者：</label>
        <input type="text" id="fld_owner" placeholder="请输入组织者名称" name="owner">
    </div>

    <div id="password_field">
        <label for="fld_password">密码：</label>
        <input type="password" id="fld_password" placeholder="密码用于结束活动投票" name="password">
    </div>

    <div>
        <input type="submit" id="createEvent" value="创建活动">
    </div>

</form>


<%@ include file="footer.jsp" %>