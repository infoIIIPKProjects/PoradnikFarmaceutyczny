<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/static/css/top-menu.css">
    <link rel="stylesheet" type="text/css" href="/resources/static/css/register-page.css">
</head>
<body>
<div class="register-page-wrapper">
    <div class="menu"/>
    <div class="title">REJESTRACJA DO SYSTEMU</div>
    <div class="register-form">
            <form action="register" method="post">
                <input id="name" name="name" type="text" placeholder="name"/><br>
                <input id="password" name="password" type="password" placeholder="password"/><br>
                <input type="submit" value="Zarejestruj"/>
            </form>
    </div>
</div>

</body>
</html>
