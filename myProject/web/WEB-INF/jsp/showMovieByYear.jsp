<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp" %>

<center>
    Фильмы за выбранный год
    <table border="1" width="30%" cellpadding="5">
        <c:forEach var="name" items="${moviesNames}">
        <tr>
            <td>${name}</td>
        <tr>
            </c:forEach>

    </table>

</center>
<%@include file="footer.jsp" %>
</body>
</html>



