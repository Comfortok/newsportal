<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
                <li><a href="<c:url value="/articles"/>" target="_blank">News list</a></li>
                <li><a href="<c:url value="/add"/>">Add news</a></li>
            </ul>
        </div>
    </div>

    <div class="grid-item item2">
        <c:if test="${!empty requestScope.error}">
            <c:out value="${requestScope.error}"/>
        </c:if>
        <c:if test="${!empty listArticles}">
            <form method="post" action="${pageContext.request.contextPath}/remove">
            <c:forEach items="${listArticles}" var="article">
                <div class="grid-table">
                    <div class="grid-item">
                        <div class="article">
                            <p>${article.header}</p>
                            <p>${article.text}</p>
                        </div>
                        <div class="grid-item">
                            <div class="date-cell">
                                    ${article.releaseDate}
                            </div>
                        </div>

                        <div class="grid-item">
                        </div>
                        <div class="grid-item">
                            <div class="modify-cell">
                                <a href="<c:url value="/edit/${article.id}"/>">Edit</a>
                                <a href="/articleInfo/${article.id}" target="_blank">View</a>
                                <a href="<c:url value="/remove/${article.id}"/>">Delete</a>
                                <td>
                                    <input type="checkbox" value="${article.id}" name="articleId">
                                </td>
                            </div>
                        </div>
                        <br/>
                    </div>
                    <br/>
                </div>
            </c:forEach>
                <input type="submit" value="Delete" onclick="return confirm('Sure, man?')"/>
            </form>
        </c:if>
    </div>
</div>

<c:import url="footer.jsp" charEncoding="UTF-8"/>
</body>
</html>