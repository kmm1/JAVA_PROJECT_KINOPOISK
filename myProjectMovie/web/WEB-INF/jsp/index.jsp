<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ include file="jstl-connect.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${not empty sessionScope.currentLanguage ? sessionScope.currentLanguage : 'ru_RU'}"/>
<fmt:setBundle basename="translations"/>

<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Enter and registration</title>
</head>
<body>
<%@include file="language-control.jsp" %>

<center>
    <table border="1" width="30%" cellpadding="3">
        <form action="${pageContext.request.contextPath}/index" method="post">
            <thead>
            <tr>
                <th colspan="2"><fmt:message key="login.enter"/></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><fmt:message key="login.email"/></td>
                <td><input type="email" name="email" value=""/></td>
            </tr>
            <tr>
                <td><fmt:message key="login.password"/></td>
                <td><input type="password" name="password" value=""/></td>
            </tr>
            <tr>
                <td><fmt:message key="login.enter"/></td>
                <td><input type="submit" value=<fmt:message key="login.enterAdmin"/>/></td>
            </tr>
            <tr>
                <td><fmt:message key="login.enterAdmin"/></td>
                <td><input type="submit" value=<fmt:message key="login.enterAdmin"/>/></td>
            </tr>
            </tbody>
        </form>
    </table>

    <form action="${pageContext.request.contextPath}/registration" method="get">
        <tr>
            <td><input type="submit" name="prof" value=<fmt:message key="login.registration"/>></input></td>
        </tr>
    </form>

</center>
</body>
</html>
