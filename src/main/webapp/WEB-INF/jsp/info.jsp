<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="pages" value="${requestScope.pages}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" width="100%">
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
<div>
    <a href="/TariffController?page=${pages.first}"><div class="first"><c:out value="${pages.first}"/></div></a>

    <a href="/TariffController?page=${pages.previous}"><div class="previous">previous</div></a>
</div>
</body>
</html>
