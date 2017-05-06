<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp" %>

<center>

    <table border="1" width="30%" cellpadding="5">
        <thead>
        <tr>
            <th colspan="5"><p>Информация об режиссерах в фильме: ${requestScope.movieName} </p></th>
        </tr>
        </thead>
        <thead>
        <tr>
            <th colspan="1">Id</th>
            <th colspan="1">ФИО</th>
            <th colspan="1">Год рождения</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="movieInfoByName2" items="${requestScope.movieInfoByName2}">
            <tr>
                <td>${movieInfoByName2.id}</td>
                <td>${movieInfoByName2.name} ${movieInfoByName2.lastname}</td>
                <td>${movieInfoByName2.yearOfBirth}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <table border="1" width="30%" cellpadding="5">
        <thead>
        <tr>
            <th colspan="5"><p>Информация об актерах в фильме: ${requestScope.movieName} </p></th>
        </tr>
        </thead>
        <thead>
        <tr>
            <th colspan="1">Id</th>
            <th colspan="1">ФИО</th>
            <th colspan="1">Год рождения</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="movieInfoByName" items="${requestScope.movieInfoByName}">
            <tr>
                <td>${movieInfoByName.actor.id}</td>
                <td>${movieInfoByName.actor.name} ${movieInfoByName.actor.lastname}</td>
                <td>${movieInfoByName.actor.yearOfBirth}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


</center>

</body>
</html>
