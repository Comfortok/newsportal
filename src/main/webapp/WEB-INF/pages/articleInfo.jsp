<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <form method="post" action="${pageContext.request.contextPath}/edit/${article.id}">
            <div class="grid-table table2">
                <div class="grid-item">
                    News Title
                </div>
                <div class="grid-item">
                    ${article.header}
                </div>
                <div class="grid-item">
                    News Date
                </div>
                <div class="grid-item">
                    ${article.releaseDate}
                </div>
                <div class="grid-item">
                    News Text
                </div>
                <div class="grid-item">
                    ${article.text}
                </div>
                <br/>
            </div>
            <input type="submit" value="Edit"/>
        </form>

        <form method="post" action="${pageContext.request.contextPath}/remove/${article.id}">
            <input type="submit" value="Delete" onclick="return confirm('Sure, man?')"/>
        </form>
    </div>
</div>

<c:import url="footer.jsp" charEncoding="UTF-8"/>
</body>
</html>