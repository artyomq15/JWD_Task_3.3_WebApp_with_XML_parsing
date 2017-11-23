<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="pages" value="${requestScope.pages}"/>
<html>
<head>
    <title>Info</title>
    <link rel="stylesheet" href="../../css/main.css">
</head>
<body>

<a href="../../index.jsp">choose parser</a>
<br/>
<h1>Parsed with <c:out value="${sessionScope.parser}"/></h1>
<table>
    <tr>
        <th>Name</th>
        <th>Operator</th>
        <th>Payroll</th>
        <th>Calls in network</th>
        <th>Calls out network</th>
        <th>Calls to landline</th>
        <th>SMS price</th>
        <th>Internet traffic</th>
        <th>Favorite numbers</th>
        <th>Tariffing</th>
        <th>Connection fee</th>
    </tr>
    <c:forEach var="tariff" items="${requestScope.tariffs}">
        <tr>
            <td><c:out value="${tariff.name}"/></td>
            <td><c:out value="${tariff.operatorName}"/></td>
            <td><c:out value="${tariff.payroll}"/></td>
            <td><c:out value="${tariff.callPrice.inNetwork}"/></td>
            <td><c:out value="${tariff.callPrice.outNetwork}"/></td>
            <td><c:out value="${tariff.callPrice.toLandline}"/></td>
            <td><c:out value="${tariff.smsPrice}"/></td>
            <td><c:out value="${tariff.internetTraffic}"/></td>
            <td><c:out value="${tariff.favoriteNumber}"/></td>
            <td><c:out value="${tariff.tariffing}"/></td>
            <td><c:out value="${tariff.connectionFee}"/></td>
        </tr>
    </c:forEach>
</table>
<br/>
<div class="pages">

    <c:if test="${pages.first != pages.current && pages.first!= pages.previous}">
        <div>
            <a href="/TariffController?page=${pages.first}"><c:out value="${pages.first}"/></a>
        </div>
        <div>...</div>
    </c:if>


    <c:if test="${pages.previous != pages.current}">
        <div>
            <a href="/TariffController?page=${pages.previous}"><c:out value="${pages.previous}"/></a>
        </div>
    </c:if>

    <div>
        <b><a><c:out value="${pages.current}"/></a></b>
    </div>

    <c:if test="${pages.next != pages.current}">
        <div>
            <a href="/TariffController?page=${pages.next}"><c:out value="${pages.next}"/></a>
        </div>
    </c:if>


    <c:if test="${pages.last != pages.current && pages.last!= pages.next}">

        <div>...</div>
        <div>
            <a href="/TariffController?page=${pages.last}"><c:out value="${pages.last}"/></a>
        </div>
    </c:if>

</div>
</body>
</html>
