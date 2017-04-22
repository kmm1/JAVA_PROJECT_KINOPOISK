<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>if/else example</title>
</head>
<body>
<c:choose>
    <c:when test="${userPref=='Perfomance'}">
        ${userName} you choose perfomance!
    </c:when>
    <c:when test="${userPref=='Safery'}">
        ${userName} you choose safery!
    </c:when>
    <c:when test="${userPref=='Maintenance'}">
        ${userName} you choose maintenance!
    </c:when>
    <c:otherwise>
        You dont choose!
    </c:otherwise>
</c:choose>
</body>
</html>