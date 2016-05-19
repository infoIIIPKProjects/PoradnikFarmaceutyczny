<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/static/css/top-menu.css">
    <link rel="stylesheet" type="text/css" href="/resources/static/css/add-choroba.css">
</head>
<body>

<div class="page-wrapper">
    <div class="menu">
        <ul class="items">
            <li class="item">
                <a href="/user/welcomePage.html">
                    <span>Lista chorób</span>
                </a>
            </li>
            <li class="item">
                <a href="/user/userWelcomePage2.html">
                    <span>Lista leków</span></a>
            </li>
            <li class="item">
                <a href="/user/addchoroba.html">
                    <span>Dodaj chorobe</span></a>
            </li>
            <li class="item">
                <a href="/user/addlek.html">
                    <span>Dodaj lek</span></a>
            </li>
            <li class="item">
                <a href='/user/viewreport${user.id}'>
                    <span>Pokaz wykresy</span></a>
            </li>
            <li class="item right">
                <a href="<c:url value="/j_spring_security_logout"/>">
                    <span>Wyloguj</span></a>
            </li>
        </ul>
    </div>
    <div class="form-wrapper">
        <form method="post" action="/user/afteraddingItem.html">
            <div class="item">
                <div>Nazwa choroby</div>
                <input type="text" value="${choroba.nazwa}" name="nazwa"/>
            </div>
            <div class="item">
                <div>Wybierz kategorie choroby:</div>
                <select name="kategoriaChoroby">
                    <c:forEach var="category" items="${kategoriaChoroby}">
                        <option value="${category.id}">${category}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="item">
                <div>Opis choroby:</div>
                <input type="text" name="description" value="${choroba.description}"/>
            </div>
            <div class="item">
                <div>Lek:</div>
                <select name="lek">
                    <c:forEach var="lek" items="${lek}">
                        <option value="${lek.id}">${lek}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="button">
                <button>Dodaj
                    <input type="submit" hidden/>
                </button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
