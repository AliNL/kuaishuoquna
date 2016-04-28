<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" scope="request" value="Event"/>
<%@ include file="header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<div id="event-details">
    <h1 id="event-name"><c:out value="${eventDetail.name}"/></h1>
    <h2 id="owner-name">组织者：<c:out value="${eventDetail.owner}"/></h2>
    <p id="event-description"><c:out value="${eventDetail.description}"/></p>
</div>

<c:if test="${eventDetail.active}">
    <form action="add-people" id="new-people">

        <div class="time-address-owner" id="time">
            <h3>时间</h3>
            <div id="exist-time">
                <c:forEach var="time" items="${time}" varStatus="row">
                    <c:out value="${time.note}"/>
                    <input type="checkbox" name="${time.id}" form="new-people">
                </c:forEach>
            </div>
            <form action="add-time" id="time-form">
                <input type="text" name="time" form="time-form">
                <input type="submit" form="time-form" value="添加">
            </form>
        </div>

        <div class="time-address-owner" id="address">
            <h3>地点</h3>
            <div id="exist-address">
                <c:forEach var="address" items="${address}" varStatus="row">
                    <c:out value="${address.note}"/>
                    <input type="checkbox" name="${address.id}" form="new-people">
                </c:forEach>
            </div>
            <form action="add-address" id="address-form">
                <input type="text" name="address" form="address-form">
                <input type="submit" form="address-form" value="添加">
            </form>
        </div>

        <div class="time-address-owner" id="people">
            <h3>参与者信息</h3>
            <label for="name">姓名：</label>
            <input type="text" id="name" name="people-name" form="new-people">
            <input type="submit" form="new-people" value="添加">
        </div>

    </form>
    <button>结束投票</button>
</c:if>

<%@ include file="footer.jsp" %>
