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

            <th colspan="2"><p> Отзывы к фильму: ${requestScope.movieName}</p></th>
        </tr>
        </thead>
        <thead>
        <tr>
            <th colspan="1">Пользователь</th>
            <th colspan="1">Отзыв</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="reviews" items="${requestScope.reviews}">
            <tr>
                <td>${reviews.user.name} ${reviews.user.lastname}</td>
                <td>${reviews.text}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</center>

</body>
</html>

