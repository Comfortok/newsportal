<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
    <title>Registration</title>
</head>
<body>

<form:form method="POST" modelAttribute="userForm">
    <h2>Create your account</h2>
    <spring:bind path="email">
            <form:input type="text" path="email" placeholder="Email"
                        autofocus="true"/>
            <form:errors path="email"/>
    </spring:bind>

    <spring:bind path="password">
            <form:input type="password" path="password" placeholder="Password"/>
            <form:errors path="password"/>
    </spring:bind>

    <spring:bind path="confirmPassword">
            <form:input type="password" path="confirmPassword" placeholder="Confirm your password"/>
            <form:errors path="confirmPassword"/>
    </spring:bind>

    <button type="submit">Submit</button>
</form:form>

</body>
</html>