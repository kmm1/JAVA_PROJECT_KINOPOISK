<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<%
    session.setAttribute("userid", null);
    session.invalidate();
    response.sendRedirect("index.jsp");
%>