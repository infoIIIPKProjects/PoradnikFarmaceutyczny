<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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


    <title>Add item</title>


    <h2>Dodaj lek</h2>

    <c:if test="${not empty errorMessage}">
        <c:out value="${errorMessage}"/>
    </c:if>

    <form method="post" action="/user/afteraddingLek.html">
        <table>

            <tr>
                <td>Nazwa leku</td>
                <td><input type="text" value="${lek.lekName}" name="nazwa"/></td>
            </tr>

            <tr>
                <td>Cena</td>
                <td><input type="text" value="${lek.cena}" name="cena"/></td>
            </tr>

            <tr>
                <td>Dostepnosc</td>
                <td><select name="dostepnosc">
                    <option value="tak">tak</option>
                    <option value="nie">nie</option>
                </select></td>
            </tr>

            <tr>
                <td>Choroba:</td>
                <td>
                    <select name="choroba">
                        <c:forEach var="choroba" items="${choroba}">
                            <option value="${choroba.id}">${choroba}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

        </table>
        <br>

        <button>Add
            <input type="submit" hidden/>

        </button>


    </form>
</head>


<body>

</body>
</html>
