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

            <th colspan="5"><p> Фильмы за: ${requestScope.yearr} год</p></th>
        </tr>
        </thead>
        <thead>
        <tr>
            <th colspan="1">Id</th>
            <th colspan="1">Название</th>
            <th colspan="1">Год выхода</th>
            <th colspan="1">Жанр</th>
            <th colspan="1">Страна</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="moviesNames" items="${requestScope.moviesNames}">
            <tr>
                <td>${moviesNames.id}</td>
                <td><a href="${pageContext.request.contextPath}
                                             /movie-details?id=${moviesNames.id}">${moviesNames.name}</a></td>
                <td>${moviesNames.year}</td>
                <td>${moviesNames.genre}</td>
                <td>${moviesNames.country}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</center>

</body>
</html>
