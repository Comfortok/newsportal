<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false" %>
<%--
  Created by IntelliJ IDEA.
  User: Olzhas_Khassenov
  Date: 2/3/2020
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Articles</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="../../index.jsp">Back to index.jsp</a>
<br/>
<br/>
<h1>Articles</h1>

<c:if test="${!empty listArticles}">
    <h4>H4 in if</h4>
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Header</th>
            <th width="120">Text</th>
            <th width="120">Date</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
            <th width="60">View</th>
        </tr>
        <c:forEach items="${listArticles}" var="article">
            <tr>
                <td>${article.id}</td>
                <td>${article.header}</td>
                <td>${article.text}</td>
                <td><fmt:formatDate pattern="dd/MM/YYYY" value="${article.releaseDate}" /></td>
                <td><a href="<c:url value="/edit/${article.id}"/>">Edit</a></td>
                <td><a href="<c:url value="/remove/${article.id}"/>">Delete</a></td>
                <td><a href="/articleInfo/${article.id}" target="_blank">View</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add an article</h1>

<c:url var="addArticle" value="/articles/add"/>

<form:form action="${addArticle}" modelAttribute="article">
    <table>
        <c:if test="${!empty article.header}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="header">
                    <spring:message text="Header"/>
                </form:label>
            </td>
            <td>
                <form:input path="header"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="text">
                    <spring:message text="Text"/>
                </form:label>
            </td>
            <td>
                <form:input path="text"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="releaseDate">
                    <spring:message text="Date"/>
                </form:label>
            </td>
            <td>
                <form:input path="releaseDate"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty article.header}">
                    <input type="submit"
                           value="<spring:message text="Edit Article"/>"/>
                </c:if>
                <c:if test="${empty article.header}">
                    <input type="submit"
                           value="<spring:message text="Add Article"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>