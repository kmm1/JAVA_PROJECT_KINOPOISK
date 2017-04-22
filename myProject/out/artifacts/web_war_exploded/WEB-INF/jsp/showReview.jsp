<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp" %>

<center>

    <p>Название фильма: ${requestScope.movieName}</p>


    <table border="1" width="30%" cellpadding="5">
        <c:forEach var="reviews" items="${reviews}">
        <tr>
            <td>${reviews}</td>
        <tr>
            </c:forEach>


    </table>


</center>
<%@include file="footer.jsp" %>
</body>
</html>
