<%--
  Created by IntelliJ IDEA.
  User: Olzhas_Khassenov
  Date: 3/2/2020
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="POST" action="${pageContext.request.contextPath}/login">
    <h2 class="form-heading">Log in</h2>

    <div class="form-group ${error != null ? 'has-error' : ''}">
        <span>${message}</span>
        <input name="email" type="text" placeholder="Email"
               autofocus="true"/>
        <input name="password" type="password" placeholder="Password"/>
        <span>${error}</span>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <button type="submit">Log In</button>
        <h4><a href="${pageContext.request.contextPath}/registration">Create an account</a></h4>
    </div>
</form>
</body>
</html>