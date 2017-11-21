<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>XML Parser</title>
</head>
<body>
    <form action="/TariffController" method="post">
        <input type="hidden" name="set_parser" value="sax">
        <input type="submit" value="SAX">
    </form>
</body>
</html>
