<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>

    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.7/css/jquery.dataTables.min.css">
    <script src="//cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

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

    <title>Add item status</title>
    <h3>kategoria Choroby added successfully</h3>

</head>
<body>


</body>
</html>
