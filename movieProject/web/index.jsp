<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Enter and registration</title>
</head>
<body>
<form method="post" action="login.jsp">
    <center>
        <table border="1" width="30%" cellpadding="3">

            <thead>
            <tr>
                <th colspan="2">Войти на сайт</th>
            </tr>
            </thead>
            <tbody>

            <tr>
                <td>e-mail</td>
                <td><input type="text" name="email" value=""/></td>
            </tr>

            <tr>
                <td>пароль</td>
                <td><input type="password" name="password" value=""/></td>
            </tr>

            <tr>
                <td><input type="submit" value="войти"/></td>
                <td><input type="reset" value="reset"/></td>
            </tr>

            <tr>
                <td colspan="2">регистрация <a href="reg.jsp">зарегистрироваться</a></td>
            </tr>

            <tr>
                <td colspan="2">админ <a href="adminenter.jsp">войти. администратор</a></td>
            </tr>

            </tbody>

        </table>
    </center>
</form>
</body>
</html>