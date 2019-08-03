<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fitness" uri="fitnessTag" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="text" var="text"/>

<fmt:message bundle="${text}" key="order.cost" var="cost"/>
<fmt:message bundle="${text}" key="order.final_cost" var="final_cost"/>
<fmt:message bundle="${text}" key="order.duration" var="duration"/>
<fmt:message bundle="${text}" key="order.discount" var="discount"/>
<fmt:message bundle="${text}" key="exercises.buy" var="buy"/>
<fmt:message bundle="${text}" key="order.extend" var="extend"/>
<fmt:message bundle="${text}" key="order.incorrect_cost" var="incorrect_cost"/>
<fmt:message bundle="${text}" key="order.incorrect_card_data" var="incorrect_card_data"/>
<fmt:message bundle="${text}" key="order.period_not_exist" var="period_not_exist"/>
<fmt:message bundle="${text}" key="order.choose_tariff" var="choose_tariff"/>
<fmt:message bundle="${text}" key="order.credit_card" var="credit_card"/>

<!doctype html>
<html lang="${sessionScope.language}">
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>Fitness-centre</title>
    <link rel="stylesheet" href="../styless/baseStyles.css" type="text/css">
    <link rel="stylesheet" href="../styless/buyGymMembershipStyles.css" type="text/css">
    <link rel="stylesheet" href="../styless/modalWindows.css" type="text/css">
    <link rel="stylesheet" href="../styless/orderPageStyles.css" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Staatliches" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Noto+Serif+TC" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Oswald:300" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato|Sarabun" rel="stylesheet">
    <script src="../scripts/buttonStyleChanger.js"></script>
    <script src="../scripts/gymCostSetters.js"></script>
    <script src="../scripts/notification.js"></script>
</head>

<body>
<div id="wrapper">
    <jsp:include page="menu.jsp">
        <jsp:param name="pageTopic" value="buy_gym_membership"/>
        <jsp:param name="currentPage" value="get_order_page"/>
    </jsp:include>
    <section>

        <div class = "container">
            <div class="rightcolumn" style="min-height: 230px;">
                <div class="card">
                    <div class="col-25">
                        <label for="period_cost">${duration}</label>
                    </div>
                    <div class="col-75">
                        <select id="period_cost" onchange="setCost()" name="period">
                            <fitness:tariffs/>
                        </select>
                    </div>

                    <div class="col-25">
                        <label for="cost">${cost}</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="cost" name="cost" value="0.0$" style="width: 95%;" readonly>
                    </div>

                    <div class="col-25">
                        <label for="personal_discount">${discount}</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="personal_discount" style="width: 95%;" name="personal_discount" value="${client_personal_discount}" readonly>
                    </div>

                    <div class="col-25">
                        <label for="final_cost">${final_cost}</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="final_cost" name="final_cost" style="width: 95%;"  value="0.0$" readonly>
                    </div>
                    <input class="modal__check" type="checkbox" id="modal"/>
                    <div class="modal">
                        <label class="modal__closetwo" for="modal"></label>
                        <div class="modal__info" style="min-height: 160px;max-width: 600px;">
                            <form name="form" action="${pageContext.servletContext.contextPath}/controller?command=update_gym_membership" method="post" style="margin-top: 10px;">
                                <input id="period" name="period" style="display: none;">
                                <label class="modal__close" for="modal">&times;</label>
                                <label for="cardNumber" style="padding-top: 5px;margin-top: 5px;font-size: 14px; font-family: 'Poppins', sans-serif; color: black;"> ${credit_card}</label>
                                <input id="cardNumber" name="cardNumber" type="text" style="margin-top: -8px;margin-left: 47px;">
                                <label for="finalCostModalWindow" style="display: table-cell;position: absolute;margin-top: 17px;font-size: 14px; font-family: 'Poppins', sans-serif; color: black;">${final_cost}</label>
                                <input id="finalCostModalWindow" name="cost" type="text" style="margin-top:10px;margin-left: 130px;" readonly>
                                <input class="button" type="submit" value="${buy}" style="position: absolute;margin-top: 60px; margin-left: -560px">
                            </form>
                        </div>
                    </div>
                    <c:if test="${payment_error == true}">
                        <h2 style="position: absolute;color: red;margin-left: 100px;padding-top: 174px;">${incorrect_card_data}</h2>
                    </c:if>
                    <c:if test="${period_not_exist_error == true}">
                        <h2 style="position: absolute;color: red;margin-left: 100px;padding-top: 214px;">${period_not_exist}</h2>
                    </c:if>
                    <c:choose>
                        <c:when test="${end_date_membership=='true'}">
                            <label onclick="checkSelectOption('${choose_tariff}')" class="buttonSub" >${extend}</label>
                        </c:when>
                        <c:otherwise>
                            <label  onclick="checkSelectOption('${choose_tariff}')" class="buttonSub">${buy}</label>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </section>
</div>
<c:if test="${invalid_cost_error eq true}">
    <script>notifyAboutInvalidData(${incorrect_cost})</script>
</c:if>

</body>
</html>

