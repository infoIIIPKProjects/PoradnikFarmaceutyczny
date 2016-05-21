<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/resources/static/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/static/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/css/top-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/css/data-table.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/static/css/jquery.dataTables.min.css"/>

    <script>
        $(function () {
            $("#chorobaList").dataTable();
        })
    </script>
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
            <li class="item selected">
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

    <div class="welcome">Witaj ${user.name}</div>
    <div align="center" class="table-wrapper">
        <div class="title">Leki</div>
        <table id="chorobaList">
            <thead>
            <th class = "list-item">Nazwa leku</th>
            <th class = "list-item">cena</th>
            <th class = "list-item">Dostepny?</th>
            <th class = "list-item">Choroba</th>
            <th class = "list-item">Usun</th>
            <th class = "list-item">Edytuj</th>
            </thead>
            <tbody class="table-body">
            <core:forEach var="lek" items="${leki}">
                <tr>
                    <td>${lek.lekName}</td>
                    <td>${lek.cena}</td>
                    <td>${lek.czyDostepny}</td>
                    <td>${lek.chorobas}</td>
                    <td class="modify"><a href="<c:url value="/user/delete-lek${lek.id}"/>">usun</a></td>
                    <td class="modify"><a href="<c:url value="/user/edit-lek${lek.id}"/>">edytuj</a></td>
                </tr>
            </core:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>