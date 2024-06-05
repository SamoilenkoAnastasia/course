<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="styles.css">
</head>
<jsp:include page="site-elements/header.jsp"/>
<body>
<%
    // Перевіряємо введений логін та пароль
    String login = request.getParameter("login");
    String password = request.getParameter("password");
    String role = "";
    if (login != null && password != null) {
        if (login.equals("admin") && password.equals("pass")) {
            // Якщо логін та пароль вірні для адміністратора
            role = "admin";
        } else if (login.equals("user") && password.equals("pass")) {
            // Якщо логін та пароль вірні для звичайного користувача
            role = "user";
        }
    }

    // Перенаправляємо користувача на відповідну сторінку залежно від ролі
    if (role.equals("admin")) {
        response.sendRedirect("admin.jsp");
    } else if (role.equals("user")) {
        response.sendRedirect("user.jsp");
    }
%>
<h1>Login Page</h1>
<form method="post" action="index.jsp">
    <label for="login">Login:</label>
    <input type="text" name="login" id="login"><br><br>
    <label for="password">Password:</label>
    <input type="password" name="password" id="password"><br><br>
    <input type="submit" value="Log in">
</form>
</body>
<jsp:include page="site-elements/footer.jsp"/>
</html>
