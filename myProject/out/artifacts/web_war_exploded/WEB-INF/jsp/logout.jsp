<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <title>Logout</title>
</head>
<body>
<h1>Вы вышли из системы!</h1>
<form action="${pageContext.request.contextPath}/index" method="get">

    <tr>
        <td><input type="submit" name="enter" value="Войдите в систему"></input></td>
    </tr>

</form>

</body>
</html>