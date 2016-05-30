<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/static/css/top-menu.css">
    <link rel="stylesheet" type="text/css" href="/resources/static/css/register-page.css">
</head>
<body>
<div class="register-page-wrapper">
    <div class="menu">
        <div class="title">REJESTRACJA DO SYSTEMU</div>
    </div>
    <div class="error">
    <c:if test="${not empty error}">
            <c:out value="${error}"></c:out>
    </c:if>
    </div>

    <div class="register-form">
        <form action="register" method="post">
            <input id="name" name="name" type="text" placeholder="login"/><br>
            <input id="password" name="password" type="password" placeholder="hasło"/><br>
            <input type="submit" value="Zarejestruj"/>
        </form>
    </div>
    <div id="greeting" class="greeting"></div>
</div>

</body>
<script src="/resources/static/js/date.js"></script>
</html>
