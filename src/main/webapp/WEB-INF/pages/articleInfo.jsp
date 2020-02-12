<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<head>
    <title>Article Data</title>
</head>
<body>
<h1>Article details</h1>

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
                <div class="grid-table">
                    <div class="grid-item">
                        News header
                    </div>
                    <div class="grid-item">
                        <p>${article.header}</p>
                    </div>
                    <div class="grid-item">
                        Date
                    </div>
                    <div class="grid-item">
                        ${article.releaseDate}
                    </div>
                    <div class="grid-item">
                        Text
                    </div>
                    <div class="grid-item">
                        <p>${article.text}</p>
                    </div>
                    <div class="grid-item">
                        <div class="modify-cell">
                            <a href="<c:url value="/edit/${article.id}"/>">Edit</a>
                            <a href="<c:url value="/remove/${article.id}"/>">Delete</a>
                        </div>
                    </div>
                    <br/>
                </div>
    </div>
</div>

</body>
</html>