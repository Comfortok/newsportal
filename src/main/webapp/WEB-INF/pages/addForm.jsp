<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<h1>Add an article</h1>

<form:form action="save" modelAttribute="article">
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
                    <spring:message text="header"/>
                </form:label>
            </td>
            <td>
                <form:input path="header"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="text">
                    <spring:message text="text"/>
                </form:label>
            </td>
            <td>
                <form:input path="text"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="releaseDate">
                    <spring:message text="releaseDate"/>
                </form:label>
            </td>
            <td>
                <form:input path="releaseDate"/>
            </td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>

        <%--<tr>
            <td>
                <form:label path="id">
                    <spring:message text="ID"/>
                </form:label>
            </td>
            <td>
                <form:input path="id" readonly="true" size="8" disabled="true"/>
                <form:hidden path="id"/>
            </td>
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
                    <input type="submit"
                           value="<spring:message text="Add Article"/>"/>
            </td>
        </tr>--%>


</body>
</html>