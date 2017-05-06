<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

Вы зарегистрированы как:
<%= session.getAttribute("userName")%>
<%= session.getAttribute("userLastname")%>


<form action="${pageContext.request.contextPath}/userContent" method="get">
    <tr>
        <td><input type="submit" name="mainPage" value="Перейти на главную"></input></td>
    </tr>
</form>

<form action="${pageContext.request.contextPath}/logout" method="get">
    <tr>
        <td><input type="submit" name="exit" value="Выйти из системы"></input></td>
    </tr>
</form>

<form action="${pageContext.request.contextPath}/getFile" method="post">
    <td>Скачать фильмы в выбранном году</td>
    <td><input type="text" name="year" value=""/></td>
    <td><input type="submit" value="Скачать файл"/></td>
</form>


