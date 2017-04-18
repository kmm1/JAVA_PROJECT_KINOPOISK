<%@ page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<%
    String userName = request.getParameter("name");
    String lastname = request.getParameter("lastname");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    if (userName.equals("") || lastname.equals("") || email.equals("") || password.equals("")) {
        response.sendRedirect("reg.jsp");
    }


    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/movie_base", "root", "root")) {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO users (name, lastname, email, password) VALUES (?,?,?,?)");
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, lastname);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, password);
        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            response.sendRedirect("welcome.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    } catch (Exception e) {
        System.out.print(e);
        e.printStackTrace();

    }
%>