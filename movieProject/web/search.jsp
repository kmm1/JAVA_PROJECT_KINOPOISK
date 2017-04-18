<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>


<%
    String year = request.getParameter("year");
    int yearr = Integer.parseInt(year);

    if (year.equals("")) {
        response.sendRedirect("content.jsp");
    }

    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
    writer.write("<table>");
    writer.write("<th>");
    writer.write("<td>Id</td><td>Name</td>");
    writer.write("</th>");


    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/movie_base", "root", "root")) {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT id, name FROM movies WHERE year = ?");
        preparedStatement.setInt(1, yearr);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            ;

            writer.write("<tr>");
            writer.write("<td>" + resultSet.getLong("id") + "</td>");
            writer.write("<td>" + resultSet.getString("name") + "</td>");
            writer.write("</tr>");
        }



       /*int i = preparedStatement.executeUpdate();
        if (i > 0) {
            response.sendRedirect("welcome.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }*/
    } catch (Exception e) {
        System.out.print(e);
        e.printStackTrace();
    }
    writer.write("</table>");
%>