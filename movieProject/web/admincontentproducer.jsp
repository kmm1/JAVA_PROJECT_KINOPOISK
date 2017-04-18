<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp" %>

<form method="post" action="search.jsp">

    <center>
        <table border="1" width="30%" cellpadding="5">

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
                <td><input type="text" name="lastname" value=""/></td>
            </tr>


            <tr>
                <td><input type="submit" value="Сохранить"/></td>
            </tr>

            <tr>
                <td colspan="2">* <a href="admincontent.jsp">вазврат в главное меню</a></td>
            </tr>


            <%@include file="footer.jsp" %>
</body>
</html>

