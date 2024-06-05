<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>User Page</title>
  <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<jsp:include page="site-elements/header.jsp"/>
<div class="container">
  <main>
    <h2>Select Language</h2>
    <form method="get" action="searchWordServlet">
      <label for="language">Language:</label>
      <select name="language" id="language">
        <option value="">--Select--</option>
        <option value="1">English</option>
        <option value="2">Spanish</option>
        <option value="3">French</option>
      </select><br><br>
      <label for="word">Word:</label>
      <input type="text" name="word" id="word"><br><br>
      <input type="submit" value="Search">
    </form>
    <hr>
    <% if (request.getParameter("word") != null && request.getAttribute("result") != null) { %>
    <h2>Search Result</h2>
    <p><strong>Word:</strong> <%= request.getParameter("word") %></p>
    <p><strong>Translations:</strong></p>
    <ul>
      <% for (String translation : (List<String>) request.getAttribute("result")) { %>
      <li><%= translation %></li>
      <% } %>
    </ul>
    <% } %>
  </main>
</div>
<jsp:include page="site-elements/footer.jsp"/>
</body>
</html>
