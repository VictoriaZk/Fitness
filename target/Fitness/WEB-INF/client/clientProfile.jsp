<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="text" var="text"/>

<fmt:message bundle="${text}" key="name" var="name"/>
<fmt:message bundle="${text}" key="surname" var="surname"/>
<fmt:message bundle="${text}" key="login" var="login"/>
<fmt:message bundle="${text}" key="coach" var="coach"/>
<fmt:message bundle="${text}" key="visit_number" var="visit_number"/>
<fmt:message bundle="${text}" key="private_discount" var="private_discount"/>
<fmt:message bundle="${text}" key="corporate_discount" var="corporate_discount"/>
<fmt:message bundle="${text}" key="membership_valid_until" var="membership_valid_until"/>
<fmt:message bundle="${text}" key="coach.not_coach" var="no_coach"/>
<fmt:message bundle="${text}" key="order.no_membership" var="no_membership"/>

<!doctype html>
<html lang="${sessionScope.language}">
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>Fitness Centre</title>
    <link rel="stylesheet" href="../../../web/styless/baseStyles.css" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Staatliches" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Oswald:300" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
    <link href="../../../web/styless/client/clientProfileStyles.css" rel="stylesheet">
    <script src="../../../web/scripts/buttonStyleChanger.js"></script>

</head>
<body>
<div id="wrapper">
    <jsp:include page="../menu.jsp">
        <jsp:param name="pageTopic" value="profile"/>
        <jsp:param name="currentPage" value="profile"/>
    </jsp:include>
        <section>
            <div class = "container">
                <div class="rightcolumn" style="width: 100%;">
                    <div class="card">

                        <jsp:useBean id="client" type="com.epam.fitness.model.Client" scope="request"/>
                        <div class="col-25">
                            <label for="Name">${name}</label>
                        </div>
                        <div class="col-75">
                            <input type="text" id="Name" name="Name" value="${client.name}" readonly>
                        </div>

                        <div class="col-25">
                            <label for="SurName">${surname}</label>
                        </div>
                        <div class="col-75">
                            <input type="text" id="SurName" name="SurName" value="${client.surname}" readonly>
                        </div>

                        <div class="col-25">
                            <label for="login">${login}</label>
                        </div>
                        <div class="col-75">
                            <input type="text" id="login" name="login" value="${client.login}" readonly>
                        </div>

                        <div class="col-25">
                            <label for="coach_name">${coach}</label>
                        </div>
                        <div class="col-75">
                            <c:choose>
                                <c:when test="${coach_name!=null}">
                                    <input type="text" id="coach_name" name="coach_name"  value="${coach_name} ${coach_surname}" readonly>
                                </c:when>
                                <c:otherwise>
                                    <input type="text" id="coach_name" name="coach_name"  value="${no_coach}" readonly>
                                </c:otherwise>
                            </c:choose>
                        </div>

                        <div class="col-25">
                            <label for="visits_number" style="width: 200px;margin-top: -4px;">${visit_number}</label>
                        </div>
                        <div class="col-75">
                            <input type="text" id="visits_number" name="visits_number"  value="${client.membershipPurchasedNumber}" readonly>
                        </div>

                        <div class="col-25" >
                            <label for="personal_discount" style="margin-top: 10px;position: absolute;margin-left: -160px;">${private_discount}</label>
                        </div>
                        <div class="col-75">
                            <input type="text" id="personal_discount" name="personal_discount"  value="${client.personalDiscount}" readonly>
                        </div>

                        <div class="col-25">
                            <label for="end_date_of_trains">${membership_valid_until}</label>
                        </div>
                        <c:choose>

                            <c:when test="${end_date_of_trains == null}">
                                <div class="col-75">
                                    <input type="text" id="end_date_of_trains" name="end_date_of_trains"  value="${no_membership}" readonly>
                                </div>
                            </c:when>

                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${sessionScope.language eq 'EN'}">
                                        <div class="col-75">
                                            <input type="text" id="end_date_of_trains" name="end_date_of_trains"  value="<fmt:formatDate value="${end_date_of_trains}" pattern="dd-MM-YYYY" />" readonly>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="col-75">
                                            <input type="text" id="end_date_of_trains" name="end_date_of_trains"  value="<fmt:formatDate value="${end_date_of_trains}" pattern="dd.MM.YYYY" />" readonly>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </section>
</div>

</body>
</html>



