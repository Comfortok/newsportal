<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Admin page</title>
</head>
<body>
ADMIN PAGE
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <c:out value="userPrincipal.name != null"/>
</c:if>
</body>
</html>