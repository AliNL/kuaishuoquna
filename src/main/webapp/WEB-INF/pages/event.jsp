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
    <form action="/event/add-people" id="new-people" method="post">

        <div class="time-address-owner" id="time">

            <h3>时间</h3>
            <div id="exist-time">
                <c:forEach var="time" items="${times}" varStatus="row">
                    <li>
                        <c:out value="${time.note}"/>
                        已有<c:out value="${time.count_number}"/>票
                        <input type="checkbox" name="time-id" value="${time.time_id}" form="new-people">
                    </li>
                </c:forEach>
            </div>
            <form action="/event/add-time" id="times-form" method="post">
                <input type="text" name="time" form="times-form">
                <button type="submit" name="url" value="${eventDetail.url}" form="times-form">添加</button>
            </form>
        </div>

        <div class="time-address-owner" id="address">
            <h3>地点</h3>
            <div id="exist-address">
                <c:forEach var="address" items="${addresses}" varStatus="row">
                    <li>
                        <c:out value="${address.note}"/>
                        已有<c:out value="${address.count_number}"/>票
                        <input type="checkbox" name="address-id" value="${address.address_id}" form="new-people">
                    </li>
                </c:forEach>
            </div>
            <form action="/event/add-address" id="address-form" method="post">
                <input type="text" name="address" form="address-form">
                <button type="submit" name="url" value="${eventDetail.url}" form="address-form">添加</button>
            </form>
        </div>

        <div class="time-address-owner" id="people">
            <h3>参与者信息</h3>
            <label for="name">姓名：</label>
            <input type="text" id="name" name="people-name" form="new-people">
            <button type="submit" name="url" value="${eventDetail.url}" form="new-people">添加</button>
        </div>

    </form>
    <button>结束投票</button>
</c:if>

<%@ include file="footer.jsp" %>
