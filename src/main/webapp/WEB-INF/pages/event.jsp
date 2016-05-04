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

    <div class="time-address-owner time">
        <h3>时间</h3>
        <div id="exist-time">
            <c:forEach var="time" items="${times}" varStatus="row">
                <li title="${time.peopleList}">
                    <c:out value="${time.note}  "/>
                    已有<c:out value="${time.count_number}"/>票
                    <input type="checkbox" name="time-id" value="${time.time_id}" form="new-people">
                </li>
            </c:forEach>
        </div>
        <form action="/event/add-time" id="time-form" method="post">
            <input type="text" name="time" form="time-form">
            <button type="submit" name="url" value="${eventDetail.url}" form="time-form">添加</button>
        </form>
    </div>

    <div class="time-address-owner address">
        <h3>地点</h3>
        <div id="exist-address">
            <c:forEach var="address" items="${addresses}" varStatus="row">
                <li title="${address.peopleList}">
                    <c:out value="${address.note}  "/>
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

    <div class="time-address-owner people">
        <h3>参与者信息</h3>
        <form action="/event/add-people" id="new-people" method="post">
            <label for="name">姓名：</label>
            <input type="text" id="name" name="people-name" form="new-people">
            <button type="submit" name="url" value="${eventDetail.url}" form="new-people">添加</button>
        </form>
    </div>
    <form action="/event/end" id="end-form" method="post">
        <input type="hidden" name="url" value="${eventDetail.url}">
    </form>
    <button id="end-event" value="${eventDetail.password}">结束投票</button>
</c:if>

<c:if test="${not eventDetail.active}">

    <div class="time-address-owner time">
        <h3>时间</h3>
        <div id="best-time">
            <c:forEach var="timeInOrder" items="${timesInOrder}" varStatus="row">
                <li title="${timeInOrder.peopleList}">
                    <c:out value="${timeInOrder.note}  "/>
                    <c:out value="${timeInOrder.count_number}"/>票
                </li>
            </c:forEach>
        </div>
    </div>

    <div class="time-address-owner address">
        <h3>地点</h3>
        <div id="best-address">
            <c:forEach var="addressInOrder" items="${addressesInOrder}" varStatus="row">
                <li title="${addressInOrder.peopleList}">
                    <c:out value="${addressInOrder.note}  "/>
                    <c:out value="${addressInOrder.count_number}"/>票
                </li>
            </c:forEach>
        </div>
    </div>

    <div class="time-address-owner people">
        <h3>参与者</h3>
        <div id="attendee">
            <c:forEach var="person" items="${people}" varStatus="row">
                <li>
                    <c:out value="${person.name}"/>
                </li>
            </c:forEach>
        </div>
    </div>

</c:if>

<%@ include file="footer.jsp" %>
