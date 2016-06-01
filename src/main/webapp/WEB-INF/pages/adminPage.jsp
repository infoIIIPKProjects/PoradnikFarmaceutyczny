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
                    <li class="item">
                        <a href="/user/addChorobaPage.html">
                            <span>Dodaj chorobe</span></a>
                    </li>
                </c:when>
                <c:when test="${user.role.roleName.equals(\"lekarz\")}">
                    <li class="item">
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
                            <span>Pokaż wykresy</span></a>
                    </li>
                </c:when>

                <c:when test="${user.role.roleName.equals(\"kierownictwo\")}">
                    <li class="item">
                        <a href='/user/viewReportPage${user.id}'>
                            <span>Pokaż wykresy</span></a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="item disabled">
                        <a><span>Pokaż wykresy</span> </a>
                    </li>
                </c:otherwise>
            </c:choose>

            <c:if test="${user.role.roleName.equals(\"admin\")}">
                <li class="item admin-panel">
                    <a href="/admin/adminPage.html">
                        <span>Panel Admina</span></a>
                </li>
            </c:if>

            <li class="item right">
                <a href="<c:url value="/j_spring_security_logout"/>">
                    <span>Wyloguj</span></a>
            </li>
        </ul>
    </div>
    <div class="form-wrapper" >
        <form method="post" action="/user/afterAddUser.html">
            <div class="item">
                <div>Nazwa Loginu</div>
                <select name="user">
                    <c:forEach var="user" items="${users}">
                        <option value="${user.name}">${user.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="button admin">
                <button name= "updateOrDelete"   value="Delete">Usuń użytkownika
                    <input type="submit"  hidden/>
                </button>
            </div>
            <div class="item">
                <div>Rola</div>
                <select name="role">
                    <c:forEach var="role" items="${roles}">
                        <option value="${role}">${role}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="button admin" >
                <button name = "updateOrDelete"  value="Update">Zmień role użytkownika
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