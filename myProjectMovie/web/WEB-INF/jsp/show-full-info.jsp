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
            <th colspan="1"><p> Id Фильма : ${requestScope.movieId},
                Название: ${requestScope.movieName},
                Страна: ${requestScope.movieCountry},
                Год: ${requestScope.movieYear},
                Жанр: ${requestScope.movieGenre}</p></th>
        </tr>
        </thead>
        <thead>
        <tr>
            <th colspan="1">Актеры</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="movieInfoByName" items="${requestScope.movieInfoByName}">
            <tr>
                <c:if test="${empty movieInfoByName.name && empty movieInfoByName.name}">
                    <td> данных нет</td>
                </c:if>
                <c:if test="${not empty movieInfoByName.actor.name}">
                <td>${movieInfoByName.name}
                    </c:if>
                    <c:if test="${not empty movieInfoByName.actor.lastname}">
                        ${movieInfoByName.actor.lastname}
                    </c:if>
                    <c:if test="${movieInfoByName.actor.yearOfBirth != 0}">
                    , ${movieInfoByName.actor.yearOfBirth}</td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <table border="1" width="30%" cellpadding="5">

        <thead>
        <tr>
            <th colspan="1">Продюссеры</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="movieInfoByName2" items="${requestScope.movieInfoByName2}">
            <tr>
                <c:if test="${empty movieInfoByName2.name && empty movieInfoByName2.name}">
                    <td> данных нет</td>
                </c:if>
                <c:if test="${not empty movieInfoByName2.name}">
                <td>${movieInfoByName2.name}
                    </c:if>
                    <c:if test="${not empty movieInfoByName2.lastname}">
                        ${movieInfoByName2.lastname}
                    </c:if>
                    <c:if test="${movieInfoByName2.yearOfBirth != 0}">
                    , ${movieInfoByName2.yearOfBirth}</td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <table border="1" width="30%" cellpadding="5">
        <thead>
        <tr>
            <th colspan="1">Отзывы</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="reviews" items="${requestScope.reviews}">
            <tr>
                <td>пользователь: ${reviews.user.name} ${reviews.user.lastname},
                    отзвыв: ${reviews.text}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</center>
</body>
</html>
</table>
</center>

</body>
</html>
