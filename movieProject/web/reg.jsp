<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration</title>
</head>
<body>
<form method="post" action="registration.jsp">

    <center>
        <table border="1" width="30%" cellpadding="5">

            <thead>
            <tr>
                <th colspan="2">Введите информацию</th>
            </tr>
            </thead>
            <tbody>


            <tr>
                <td>имя</td>
                <td><input type="text" name="name" value=""/></td>
            </tr>

            <tr>
                <td>фамилия</td>
                <td><input type="text" name="lastname" value=""/></td>
            </tr>

            <tr>
                <td>email</td>
                <td><input type="text" name="email" value=""/></td>
            </tr>

            <tr>
                <td>пароль</td>
                <td><input type="password" name="password" value=""/></td>
            </tr>

            <tr>
                <td>пароль еще раз</td>
                <td><input type="password" name="passwordRepeat" value=""/></td>

            </tr>

            <tr>
                <td><input type="submit" value="зарегистрироваться"/></td>
            </tr>

            <tr>
                <td colspan="2">уже зарегистрированы? <a href="index.jsp">вход</a></td>
            </tr>

            </tbody>
        </table>
    </center>
</form>
</body>
</html>