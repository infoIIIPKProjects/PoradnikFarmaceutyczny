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
            <li class="item">
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
        <form method="post" action="/user/aftereditingItem.html">
            <input type="hidden" name="choroba_id" value="${choroba_id}">
            <div class="item">
                <div>Nazwa choroby</div>
                <input type="text" value="${choroba.nazwa}" name="nazwa"/>
            </div>
            <div class="item">
                <div>Wybierz kategorie choroby:</div>
                <select name="kategoriaChoroby">
                    <option value="${choroba.kategoriaChoroby.id}"
                            selected>${choroba.kategoriaChoroby}</option>
                    <c:forEach var="category" items="${kategoriaChoroby}">
                        <c:if test="${category.id ne choroba.kategoriaChoroby.id}">
                            <option value="${category.id}">${category}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="item wide">
                <div>Opis choroby:</div>
                <input type="text" name="description" value="${choroba.description}"/>
            </div>
            <div class="item">
                <div>Lek:</div>
                <select name="lek">
                    <option value="${choroba.lek.id}" selected>${choroba.lek}</option>
                    <c:forEach var="lek" items="${lek}">
                        <c:if test="${lek.id ne choroba.lek.id}">
                            <option value="${lek.id}">${lek}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="button">
                <button>Edytuj
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
