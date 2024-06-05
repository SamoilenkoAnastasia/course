<header>
  <h1>Online Dictionary</h1>
  <div class="navbar">
    <a href="index.jsp" class="active">Home</a>
    <c:if test="${sessionScope.role == 'admin'}">
      <a href="admin.jsp">Admin</a>
    </c:if>
    <c:if test="${sessionScope.role == 'user'}">
      <a href="user.jsp">User</a>
    </c:if>
    <a href="logout.jsp" style="float:right;">Logout</a>
  </div>
</header>
