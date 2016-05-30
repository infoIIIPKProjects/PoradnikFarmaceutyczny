<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/static/css/top-menu.css">
    <link rel="stylesheet" type="text/css" href="/resources/static/css/login-page.css">
</head>
<body>
<div class="login-page-wrapper">
    <div class="menu"/>
    <div class="title">LOGOWANIE DO SYSTEMU</div>
    <div class="error">
        <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
            Zły login lub hasło.<br>
            Spróbuj jeszcze raz.
        </c:if>
    </div>
    <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>

    <div class="login-form">
        <form action="/j_spring_security_check" method="POST">
            <input id="name" name="name" type="text" placeholder="login"/><br>
            <input id="password" name="password" type="password" placeholder="hasło"/><br>
            <input type="submit" value="Zaloguj"/>
        </form>
    </div>
    <div id="greeting" class="greeting"></div>
</div>

</body>
<script src="/resources/static/js/date.js"></script>
</html>
