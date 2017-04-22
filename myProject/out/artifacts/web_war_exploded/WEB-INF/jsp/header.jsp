<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<%= session.getAttribute("userName")%>
<%= session.getAttribute("userLastname")%>
<%= session.getAttribute("userId")%>


<form action="${pageContext.request.contextPath}/userContent" method="get">
    <tr>
        <td><input type="submit" name="mainPage" value="Перейти на главную"></input></td>
    </tr>
</form>


<form action="${pageContext.request.contextPath}/logout" method="post">
    <tr>
        <td><input type="submit" name="exit" value="Выйти из системы"></input></td>
    </tr>
</form>

