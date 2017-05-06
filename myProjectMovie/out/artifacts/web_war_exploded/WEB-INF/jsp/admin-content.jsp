<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ include file="jstl-connect.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp" %>

<center>

    <table border="1" width="30%" cellpadding="5">
        <form action="${pageContext.request.contextPath}/saveActor" method="post">
            <thead>
            <tr>
                <th colspan="2">Добавить актера</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Имя</td>
                <td><input type="text" name="name" value=""/></td>
            </tr>
            <tr>
                <td>Фамилия</td>
                <td><input type="text" name="lastname" value=""/></td>
            </tr>
            <tr>
                <td>Год рождения</td>
                <td><input type="text" name="year" value=""/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Сохранить"/></td>
            </tr>
            </tbody>
        </form>
    </table>


    <table border="1" width="30%" cellpadding="5">
        <form action="${pageContext.request.contextPath}/saveProducer" method="post">
            <thead>
            <tr>
                <th colspan="2">Добавить режиссера</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Имя</td>
                <td><input type="text" name="name" value=""/></td>
            </tr>
            <tr>
                <td>Фамилия</td>
                <td><input type="text" name="lastname" value=""/></td>
            </tr>
            <tr>
                <td>Год рождения</td>
                <td><input type="text" name="year" value=""/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Сохранить"/></td>
            </tr>
            </tbody>
        </form>
    </table>


    <table border="1" width="30%" cellpadding="5">
        <form action="${pageContext.request.contextPath}/saveMovie" method="post">

            <thead>
            <tr>
                <th colspan="2">Добавить фильм</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Название</td>
                <td><input type="text" name="name" value=""/></td>
            </tr>
            <tr>
                <td>Страна</td>
                <td><input type="text" name="country" value=""/></td>
            </tr>
            <tr>
                <td>Год выхода</td>
                <td><input type="text" name="year" value=""/></td>
            </tr>
            <tr>
                <td>Жанр</td>
                <td><input type="text" name="genre" value=""/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Сохранить"/></td>
            </tr>
            </tbody>
        </form>
    </table>


    <table border="1" width="30%" cellpadding="5">
        <form action="${pageContext.request.contextPath}/saveMovieActor" method="post">

            <thead>
            <tr>
                <th colspan="2">Добавить актеров к фильму</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Фильм</td>
                <td><select id="movie" class="form-control" name="movieId">
                    <c:forEach items="${requestScope.listMovies}" var="movie">
                        <option value="${movie.id}">${movie.name}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td>Aктер</td>
                <td><select id="actor" class="form-control" name="actorId">
                    <c:forEach items="${requestScope.listActors}" var="actor">
                        <option value="${actor.id}">${actor.name}, ${actor.lastname}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td><input type="submit" value="Сохранить"/></td>
            </tr>
            </tbody>
        </form>
    </table>

    <table border="1" width="30%" cellpadding="5">
        <form action="${pageContext.request.contextPath}/saveMovieProducer" method="post">

            <thead>
            <tr>
                <th colspan="2">Добавить режиссеров к фильму</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Фильм</td>
                <td><select id2="movie" class="form-control" name="movieId">
                    <c:forEach items="${requestScope.listMovies}" var="movie">
                        <option value="${movie.id}">${movie.name}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td>Режиссер</td>
                <td><select lastname="producer" class="form-control" name="producerId">
                    <c:forEach items="${requestScope.listProducers}" var="producer">
                        <option value="${producer.id}">${producer.name}, ${producer.lastname}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td><input type="submit" value="Сохранить"/></td>
            </tr>

            </tbody>
        </form>
    </table>


</center>
<%@include file="footer.jsp" %>
</body>
</html>