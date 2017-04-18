<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<%

    String email = request.getParameter("email");
    String password = request.getParameter("password");

    if (email.equals("") || password.equals("")) {
        response.sendRedirect("index.jsp");
    }

    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/movie_base", "root", "root")) {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM users WHERE email=? AND password=?");
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            session.setAttribute("userid", resultSet.getString("id"));
            session.setAttribute("userName", resultSet.getString("name"));
            session.setAttribute("userLastname", resultSet.getString("lastname"));
            //System.out.println(session.getAttribute("userName"));
            if ( resultSet.getString("role").equals("user"))
                response.sendRedirect("success.jsp");
            if ( resultSet.getString("role").equals("admin"))
                response.sendRedirect("admincontent.jsp");

        } else {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.write("<h4>Неверный пароль или имя пользователя </h4> <a href='index.jsp'>Войти</a> </h4> <a href='index.jsp'>Зарегистрироваться</a>");
        }

    } catch (Exception e) {
        System.out.print(e);
        e.printStackTrace();
    }
%>