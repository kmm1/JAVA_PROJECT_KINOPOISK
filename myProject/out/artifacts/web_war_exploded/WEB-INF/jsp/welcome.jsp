<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>Регистрация прошла успешно!</h1>
<form action="${pageContext.request.contextPath}/index" method="get">

    <tr>
        <td><input type="submit" name="enter" value="Войдите в систему"></input></td>
    </tr>

</form>

</body>
</html>