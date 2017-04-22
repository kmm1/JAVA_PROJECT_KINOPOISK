<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Artist info</title>
</head>
<body>
<p>Id исполнителя: ${requestScope.artist.id}</p>
<p>Имя исполнителя: ${requestScope.artist.name}</p>
<p>Классическая музыка: ${requestScope.artist.classical}</p>
</body>
</html>
