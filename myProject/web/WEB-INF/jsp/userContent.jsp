<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp" %>

<center>

    <table border="1" width="30%" cellpadding="5">
        <form action="${pageContext.request.contextPath}/searchMovieByYear" method="post">
            <thead>
            <tr>
                <th colspan="2">Поиск фильмов по году</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Введите год</td>
                <td><input type="text" name="year" value=""/></td>
            </tr>
            <tr>
                <td>Поиск</td>
                <td><input type="submit" value="Поиск"/></td>
            </tr>
            </tbody>
        </form>
    </table>

    <table border="1" width="30%" cellpadding="5">
        <form action="${pageContext.request.contextPath}/searchActorProducer" method="post">
            <thead>
            <tr>
                <th colspan="2">Просмотреть актеров/режисеров</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Введите название фильма</td>
                <td><input type="text" name="name" value=""/></td>
            </tr>
            <tr>
                <td>Поиск</td>
                <td><input type="submit" value="Поиск"/></td>
            </tr>
            </tbody>
        </form>
    </table>

    <table border="1" width="30%" cellpadding="5">
        <form action="${pageContext.request.contextPath}/addReview" method="post">
            <thead>
            <tr>
                <th colspan="2">Добавить отзыв к фильму</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Введите название фильма</td>
                <td><input type="text" name="name" value=""/></td>
            </tr>
            <tr>
                <td>Введите отзыв</td>
                <td><input type="text" name="review" value=""/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Добавить отзыв"/></td>
            </tr>
            </tbody>
        </form>
    </table>

</center>
<%@include file="footer.jsp" %>
</body>
</html>

