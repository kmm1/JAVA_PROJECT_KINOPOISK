<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>

<form method="post" action="search.jsp">

    <center>
        <table border="1" width="30%" cellpadding="5">

            <thead>
            <tr>
                <th colspan="2">Поиск фильма</th>
            </tr>
            </thead>
            <tbody>


            <tr>
                <td>Название фильма</td>
                <td><input type="text" name="name" value=""/></td>
            </tr>

            <tr>
                <td>Год</td>
                <td><input type="text" name="year" value=""/></td>
            </tr>


            <tr>
                <td><input type="submit" value="Поиск"/></td>
            </tr>


<%@include file="footer.jsp"%>
</body>
</html>

