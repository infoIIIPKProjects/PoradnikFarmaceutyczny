<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/static/css/top-menu.css">
    <link rel="stylesheet" type="text/css" href="/resources/static/css/form.css">
</head>
<body>

<div class="page-wrapper">
    <div class="menu">
        <ul class="items">
            <li class="item">
                <a href="/user/chorobaListPage.html">
                    <span>Lista chorób</span>
                </a>
            </li>
            <li class="item">
                <a href="/user/lekListPage.html">
                    <span>Lista leków</span></a>
            </li>
            <li class="item">
                <a href="/user/addChorobaPage.html">
                    <span>Dodaj chorobe</span></a>
            </li>
            <li class="item selected">
                <a href="/user/addLekPage.html">
                    <span>Dodaj lek</span></a>
            </li>
            <li class="item">
                <a href='/user/viewReportPage${user.id}'>
                    <span>Pokaz wykresy</span></a>
            </li>
            <li class="item right">
                <a href="<c:url value="/j_spring_security_logout"/>">
                    <span>Wyloguj</span></a>
            </li>
        </ul>
    </div>
    <div class="form-wrapper">
        <form method="post" action="/user/afteraddingLek.html">
            <div class="item">
                <div>Nazwa leku</div>
                <input type="text" value="${lek.lekName}" name="nazwa"/>
            </div>
            <div class="item">
                <div>Cena</div>
                <input type="text" value="${lek.cena}" name="cena"/>
            </div>
            <div class="item">
                <div>Dostepnosc</div>
                <select name="dostepnosc">
                    <option value="tak">tak</option>
                    <option value="nie">nie</option>
                </select>
            </div>
            <div class="item">
                <div>Choroba:</div>
                <select name="choroba">
                    <c:forEach var="choroba" items="${choroba}">
                        <option value="${choroba.id}">${choroba}</option>
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
    <div id="greeting" class="greeting"></div>
</div>
</body>
<script src="/resources/static/js/date.js"></script>
</html>
