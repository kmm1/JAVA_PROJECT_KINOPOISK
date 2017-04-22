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
                <th colspan="2">Добавить режисера</th>
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
            <td>Фамилия актера</td>
            <td><input type="text" name="actLastname" value=""/></td>
        </tr>

        <tr>
            <td>Фамилия режисера</td>
            <td><input type="text" name="prodLastname" value=""/></td>
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