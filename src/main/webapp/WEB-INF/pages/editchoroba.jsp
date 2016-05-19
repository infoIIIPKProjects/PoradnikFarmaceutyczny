<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <meta charset="utf-8">


    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.7/css/jquery.dataTables.min.css">
    <script src="//cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>

    <meta name="viewport" content="width=device-width, initial-scale=1">


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

    <link href="<c:url value="/resources/static/css/demo.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/menu.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/static/js/menu.js" />"></script>


    <div id='cssmenu'>
        <ul>
            <li><a href="/user/welcomePage.html"><span>Lista chorób</span></a></li>
            <li><a href="/user/userWelcomePage2.html"><span>Lista leków</span></a></li>
            <li class='active'><a href="/user/addChorobaPage.html"><span>Dodaj chorobe</span></a></li>
            <li class='active'><a href="/user/addlek.html"><span>Dodaj lek</span></a></li>
            <li><a href='/user/viewreport${user.id}'><span>Pokaz wykresy</span></a></li>
            <li class='rightside'><a href="<c:url value="/j_spring_security_logout" />"><span>Logout</span></a></li>
        </ul>
    </div>



    <title>edititem</title>


    <h2>Edit item</h2>

    <form method="post" action="/user/aftereditingItem.html">
        <table>
            <tr>
                <td>Id uzytkownika:</td>
                <td><input type="number" name="userId" value="${user.id}" disabled/></td>
            </tr>
            <input type="hidden" name="choroba_id" value="${choroba_id}">

            <tr>
                <td>Nazwa choroby</td>
                <td><input type="text" value="${choroba.nazwa}" name="nazwa"/></td>
            </tr>

            <tr>
                <td>Wybierz kategorie choroby:</td>
                <td>
                    <select name="kategoriaChoroby">
                        <option value="${choroba.kategoriaChoroby.id}"
                                selected>${choroba.kategoriaChoroby}</option>
                        <c:forEach var="category" items="${kategoriaChoroby}">
                            <c:if test="${category.id ne choroba.kategoriaChoroby.id}">
                                <option value="${category.id}">${category}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td>Opis choroby:</td>
                <td><input type="text" name="description" value="${choroba.description}"/></td>
                s
            </tr>

            <tr>
                <td>Lek:</td>
                <td>
                    <select name="lek">
                        <option value="${choroba.lek.id}" selected>${choroba.lek}</option>
                        <c:forEach var="lek" items="${lek}">
                            <c:if test="${lek.id ne choroba.lek.id}">
                                <option value="${lek.id}">${lek}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
            </tr>

        </table>

        <br>

        <button>Edit
            <input type="submit" hidden/>

        </button>

    </form>

</head>
</body>
</html>
