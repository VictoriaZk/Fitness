<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="text" var="text"/>

<fmt:message bundle="${text}" key="order.cost" var="cost"/>
<fmt:message bundle="${text}" key="order.credit_card" var="credit_card"/>
<fmt:message bundle="${text}" key="order.payment_data" var="payment_data"/>

<!doctype html>
<html lang="${sessionScope.language}">
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>Whitesquare</title>
    <link rel="stylesheet" href="../../../web/styless/baseStyles.css" type="text/css">
    <link rel="stylesheet" href="../../../web/styless/client/clientProfileStyles.css" type="text/css">
    <link rel="stylesheet" href="../../../web/styless/tableStyles.css" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Staatliches" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Oswald:300" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
</head>
<body>
<div id="wrapper">
    <jsp:include page="../menu.jsp">
        <jsp:param name="pageTopic" value="orders"/>
        <jsp:param name="currentPage" value="orders"/>
    </jsp:include>
    <section>
        <div class="container">
            <div class="rightcolumn" style="overflow-y: scroll; overflow-x: hidden;height: 350px;">
                <c:choose>
                    <c:when test="${fn:length(orders) eq 0}">
                        <h3 style="margin-left: 10px;"><c:out value="There is no orders now"/></h3>
                    </c:when>
                    <c:otherwise>
                        <table>
                            <tr>
                                <th>Id</th>
                                <th>${cost}</th>
                                <th>${payment_data}</th>
                                <th>${credit_card}</th>
                            </tr>
                            <c:forEach items="${orders}" var="order">
                                <tr>
                                    <td>${order.id}</td>
                                    <td style="text-align: center;">${order.cost}</td>
                                    <td >
                                        <c:choose>
                                            <c:when test="${sessionScope.language eq 'EN'}">
                                                <div class="col-75" style="color: #516b9e;width: 150px">
                                                    <fmt:formatDate value="${order.paymentData}" pattern="dd-MM-YYYY HH:mm:ss" />
                                                </div>
                                            </c:when>
                                            <c:otherwise>
                                                <div class="col-75" style="color: #516b9e;width: 150px">
                                                    <fmt:formatDate value="${order.paymentData}" pattern="dd.MM.YYYY HH:mm:ss" />
                                                </div>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>************${fn:substring(order.cardNumber,12 ,16 )}</td>
                                </tr>
                            </c:forEach>

                        </table>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </section>
</div>

</body>
</html>

