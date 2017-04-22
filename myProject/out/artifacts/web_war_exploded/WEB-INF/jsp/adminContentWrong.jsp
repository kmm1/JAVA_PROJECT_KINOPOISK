<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp" %>

<center>

            <thead>
            <tr>

                <th colspan="2">Неверные данные</th>
            </tr>
            </thead>


    <form action="${pageContext.request.contextPath}/saveActor" method="get">

        <tr>
            <td><input type="submit" name="back" value="Вернуться назад"></input></td>
        </tr>
    </form>


</center>
<%@include file="footer.jsp" %>
</body>
</html>