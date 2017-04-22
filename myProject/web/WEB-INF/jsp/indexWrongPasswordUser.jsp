<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Enter and registration</title>
</head>
<body>

<center>

    <table border="1" width="30%" cellpadding="3">
        <form action="${pageContext.request.contextPath}/index" method="post">
            <thead>
            <tr>
                <th colspan="2">Неверный email или пароль</th>
            </tr>
            </thead>
            <thead>
            <tr>
                <th colspan="2">Введите данные еще раз</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>email</td>
                <td><input type="email" name="email" value=""/></td>
            </tr>
            <tr>
                <td>пароль</td>
                <td><input type="password" name="password" value=""/></td>
            </tr>
            <tr>
                <td>вход</td>
                <td><input type="submit" value="вход"/></td>
            </tr>
            <tr>
                <td>вход администратор</td>
                <td><input type="submit" value="вход администратор"/></td>
            </tr>
            </tbody>
        </form>
    </table>

    <form action="${pageContext.request.contextPath}/registration" method="get">
        <tr>
            <td><input type="submit" name="prof" value="зарегистрироваться"></input></td>
        </tr>
    </form>

</center>
</body>
</html>

