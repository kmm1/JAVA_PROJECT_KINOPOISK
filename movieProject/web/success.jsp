<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
%>
Вы не вошли на сайт<br/>
<a href="index.jsp">Войти</a>
<%
} else {
%>
Вы зарегистрированы как <%=session.getAttribute("userName")%> <%=session.getAttribute("userLastname")%>
<a href='logout.jsp'>Log out</a>
<a href='content.jsp'>Перейти на главную</a>

<%
    }
%>