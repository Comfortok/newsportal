<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<head>
    <c:import url="header.jsp" charEncoding="UTF-8"/>
</head>
<body>

<div class="grid-container">
    <div class="grid-item item1">
        <div class="nav">
            <ul>
                <li><a href="<c:url value="/articles"/>">
                    <spring:message code="nav.list"/>
                </a></li>
                <li><a href="<c:url value="/add"/>">
                    <spring:message code="nav.add"/>
                </a></li>
            </ul>
        </div>
    </div>

    <div class="grid-item item2">
        <form method="post" action="${pageContext.request.contextPath}/edit/${article.id}">
            <div class="grid-table table2">
                <div class="grid-item">
                    <spring:message code="article.title"/>
                </div>
                <div class="grid-item">
                    ${article.header}
                </div>
                <div class="grid-item">
                    <spring:message code="article.date"/>
                </div>
                <div class="grid-item">
                    ${article.releaseDate}
                </div>
                <div class="grid-item">
                    <spring:message code="article.text"/>
                </div>
                <div class="grid-item">
                    ${article.text}
                </div>
                <br/>
            </div>
            <input type="submit" value="<spring:message code="article.edit"/>"/>
        </form>

        <form method="post" action="${pageContext.request.contextPath}/remove/${article.id}">
            <input type="submit" value="<spring:message code="article.delete"/>"
                   onclick="return confirm('<spring:message code="onclick.delete"/>')"/>
        </form>
    </div>
</div>

<c:import url="footer.jsp" charEncoding="UTF-8"/>
</body>
</html>