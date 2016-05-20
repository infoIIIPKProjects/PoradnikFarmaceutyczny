<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <title>login result</title>

    <meta charset="utf-8">


    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.7/css/jquery.dataTables.min.css">
    <script src="//cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

    <link href="<c:url value="/resources/static/css/demo.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/menu.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/static/js/menu.js" />"></script>

    <link href="<c:url value="/resources/static/css/jquery.dataTables.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/static/js/jquery.dataTables.js" />"></script>
    <script src="<c:url value="/resources/static/js/jquery.js" />"></script>

    <link rel="stylesheet" type="text/css"
          href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8"
            src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" charset="utf8"
            src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>

</head>

<div id='cssmenu'>
    <ul>
        <li><a href="/user/welcomePage.html"><span>Lista chorób</span></a></li>
        <li><a href="/user/userWelcomePage2.html"><span>Lista leków</span></a></li>
        <li class='active'><a href="/user/addChorobaPage.html"><span>Dodaj chorobe</span></a></li>
        <li class='active'><a href="/user/addLekPage.html"><span>Dodaj lek</span></a></li>
        <li><a href='/user/viewreport${user.id}'><span>Pokaz wykresy</span></a></li>
        <li class='rightside'><a href="<c:url value="/j_spring_security_logout" />"><span>Logout</span></a></li>
    </ul>
</div>

<body>
<h3>Dane statystyczne</h3>
<table id="Report">
    <tbody>
    <tr>
        <img src="${kategorieObraz}"/>
    </tr>
    </tbody>
    <tbody>
    <tr>
        <img src="${chorobyLekiObraz}"/>
    </tr>
    </tbody>
    <tbody>
    <tr>
        <img src="${dostepnoscObraz}"/>
    </tr>
    </tbody>
    <tbody>
    <tr>
        <img src="${cenyLekowObraz}"/>
    </tr>
    </tbody>
</table>

</body>
</html>
