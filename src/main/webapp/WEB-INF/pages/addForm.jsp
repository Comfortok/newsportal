<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
    <c:import url="header.jsp" charEncoding="UTF-8"/>
</head>
<body>

<div class="grid-container">
    <div class="grid-item item1">
        <div class="nav">
            <ul>
                <li><a href="<c:url value="/articles"/>" target="_blank">News list</a></li>
                <li><a href="<c:url value="/add"/>">Add news</a></li>
            </ul>
        </div>
    </div>

    <div class="grid-item item2">
        <c:url value="/articles/save" var="saveAction"/>
        <form:form action="${saveAction}" modelAttribute="article">
            <c:if test="${!empty article.header}">
                <form:hidden path="id"/>
            </c:if>
            <div class="grid-table table2">
                <div class="grid-item">
                    <form:label path="header">
                        <spring:message text="Header"/>
                    </form:label>
                </div>
                <div class="grid-item">
                    <form:input path="header"/>
                </div>
                <div class="grid-item">
                    <form:label path="releaseDate">
                        <spring:message text="Release Date"/>
                    </form:label>
                </div>
                <div class="grid-item">
                    <form:input path="releaseDate"/>
                </div>
                <div class="grid-item">
                    <form:label path="text">
                        <spring:message text="Text"/>
                    </form:label>
                </div>
                <div class="grid-item">
                    <form:input path="text"/>
                </div>
                <br/>
            </div>
            <input type="submit" value="Save"/>
        </form:form>
    </div>
</div>
</body>
</html>