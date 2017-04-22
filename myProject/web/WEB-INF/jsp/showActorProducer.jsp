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
    Съемочная группа
    <table border="1" width="30%" cellpadding="5">
        <c:forEach var="producers" items="${selectMovieByName.get().getSetProducer()}">
        <tr>
            <td>${producers}</td>
        <tr>
            </c:forEach>
    </table>

    <table border="1" width="30%" cellpadding="5">
        <c:forEach var="actors" items="${selectMovieByName.get().getSetActor()}">
        <tr>
            <td>${actors}</td>
        <tr>
            </c:forEach>
    </table>


</center>
<%@include file="footer.jsp" %>
</body>
</html>



