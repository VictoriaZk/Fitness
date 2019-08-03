<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="text" var="text"/>

<fmt:message bundle="${text}" key="error.back" var="previous"/>



<html>
<head>
    <title>Show Error Page</title>
</head>

<body>
<h1>Opps...</h1>
<table width = "100%" border = "1">

    <tr valign = "top">
        <td><b>Status code:</b></td>
        <td>${error_message}</td>
    </tr>


</table>

</body>
</html>
