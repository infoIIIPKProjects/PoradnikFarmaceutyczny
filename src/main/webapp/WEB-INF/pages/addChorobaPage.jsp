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
    <div id="menu" class="menu">
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

            <c:choose>
                <c:when test="${user.role.roleName.equals(\"admin\")}">
                    <li class="item selected">
                        <a href="/user/addChorobaPage.html">
                            <span>Dodaj chorobe</span></a>
                    </li>
                </c:when>
                <c:when test="${user.role.roleName.equals(\"lekarz\")}">
                    <li class="item selected">
                        <a href="/user/addChorobaPage.html">
                            <span>Dodaj chorobe</span></a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="item disabled">
                        <a><span>Dodaj chorobe</span></a>
                    </li>
                </c:otherwise>
            </c:choose>

            <c:choose>
                <c:when test="${user.role.roleName.equals(\"admin\")}">
                    <li class="item">
                        <a href="/user/addLekPage.html">
                            <span>Dodaj lek</span></a>
                    </li>
                </c:when>
                <c:when test="${user.role.roleName.equals(\"magazyn\")}">
                    <li class="item">
                        <a href="/user/addLekPage.html">
                            <span>Dodaj lek</span></a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="item disabled">
                        <a> <span>Dodaj lek</span> </a>
                    </li>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${user.role.roleName.equals(\"admin\")}">
                    <li class="item">
                        <a href='/user/viewReportPage${user.id}'>
                            <span>Pokaz wykresy</span></a>
                    </li>
                </c:when>

                <c:when test="${user.role.roleName.equals(\"kierownictwo\")}">
                    <li class="item">
                        <a href='/user/viewReportPage${user.id}'>
                            <span>Pokaz wykresy</span></a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="item disabled">
                        <a><span>Pokaz wykresy</span> </a>
                    </li>
                </c:otherwise>
            </c:choose>

            <c:if test="${user.role.roleName.equals(\"admin\")}">
                <li class="item admin-panel">
                    <a href="/user/adminPage.html">
                        <span>Panel Admina</span></a>
                </li>
            </c:if>

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
            <div class="item wide">
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
    <div id="greeting" class="greeting"></div>
</div>
</body>
<script src="/resources/static/js/date.js"></script>
</html>
