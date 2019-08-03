<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="text" var="text"/>

<fmt:message bundle="${text}" key="nutrition.cant_choose_membership" var="cant_choose_membership"/>
<fmt:message bundle="${text}" key="exercises.buy" var="buy"/>
<fmt:message bundle="${text}" key="nutrition.morning" var="morning"/>
<fmt:message bundle="${text}" key="nutrition.lunch" var="lunch"/>
<fmt:message bundle="${text}" key="nutrition.dinner" var="dinner"/>
<fmt:message bundle="${text}" key="exercises.update" var="update"/>
<fmt:message bundle="${text}" key="nutrition.incorrect_data" var="incorrect_data"/>
<fmt:message bundle="${text}" key="nutrition.save" var="save"/>
<fmt:message bundle="${text}" key="nutrition.max_symbols" var="max_symbols"/>

<!doctype html>
<html lang="${sessionScope.language}">
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>Whitesquare</title>
    <link rel="stylesheet" href="../../../web/styless/baseStyles.css" type="text/css">
    <link rel="stylesheet" href="../../../web/styless/client/clientProfileStyles.css" type="text/css">
    <link rel="stylesheet" href="../../../web/styless/client/clientExerciseStyle.css" type="text/css">
    <link rel="stylesheet" href="../../../web/styless/modalWindows.css" type="text/css">
    <link rel="stylesheet" href="../../../web/styless/client/clientNutritionStyles.css" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Staatliches" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
    <script src="../../../web/scripts/nutritionArgumentsSetter.js"></script>
    <script src="../../../web/scripts/notification.js"></script>

<body>
<div id="wrapper">
    <jsp:include page="../menu.jsp">
        <jsp:param name="pageTopic" value="nutrition"/>
        <jsp:param name="currentPage" value="show_client_nutrition"/>
    </jsp:include>
    <section>
        <div class="container">
            <div class="rightcolumn">
                <c:choose>
                    <c:when test="${is_membership_valid == false}" >
                        <div class="flex-container">
                            <div class="flex-item" style="color:#516b9e;width:500px;">
                                <h3>${cant_choose_membership}</h3>
                            </div>
                            <div class="flex-item" style="margin-top: -10px; margin-left: -15px;">
                                <form action="${pageContext.servletContext.contextPath}/controller?command=get_order_page" method="post">
                                    <input type="submit" class="button" style="color: white; text-align: center; margin: 10px 15px 5px -10px;width: 80px; height: 50px; font: 14px Tahoma, sans-serif; background: #29c5e6;
" value="${buy}">
                                </form>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <jsp:useBean id="nutrition" class="com.epam.fitness.model.Nutrition" scope="request"/>
                        <div class="tabs">
                            <input class="tabs__tab" type="radio" id="tabs__tab1" onclick="setArguments('morning')" name="tabstab" style="display: none;" checked="checked"/>
                            <label class="tabs__title" for="tabs__tab1">${morning}</label>
                            <div class="tabs__text" style="font-family: 'Poppins', sans-serif;color: #000;font-size: 15px;">
                                <pre id="morning" style="font-family: 'Poppins', sans-serif;color: #000;font-size: 15px;">${nutrition.morningNutrition}</pre>
                            </div>

                            <input class="tabs__tab" type="radio" id="tabs__tab2" onclick="setArguments('lunch')" name="tabstab" style="display: none;" checked="checked"/>
                            <label class="tabs__title" for="tabs__tab2">${lunch}</label>
                            <div class="tabs__text" style="font-family: 'Poppins', sans-serif;color: #000;font-size: 15px;">
                                <pre  id="lunch" style="font-family: 'Poppins', sans-serif;color: #000;font-size: 15px;">${nutrition.lunchNutrition}</pre>

                            </div>

                            <input class="tabs__tab" type="radio" id="tabs__tab3" onclick="setArguments('dinner')" name="tabstab" style="display: none;" checked="checked"/>
                            <label class="tabs__title" for="tabs__tab3">${dinner}</label>
                            <div class="tabs__text" style="font-family: 'Poppins', sans-serif;color: #000;font-size: 15px;">
                                <pre id="dinner" style="font-family: 'Poppins', sans-serif;color: #000;font-size: 15px;">${nutrition.dinnerNutrition}</pre>
                            </div>

                        </div>
                        <input class="modal__check" type="checkbox" id="modal"/>
                        <div class="modal">
                            <label class="modal__closetwo" for="modal"></label>
                            <div class="modal__info">
                                <label class="modal__close" for="modal">&times;</label>
                                <form name="form" action="${pageContext.request.contextPath}/controller?command=update_nutrition" method="post">
                                    <input id="nutrition_id" name="nutrition_id" value="${nutrition.id}" style="display: none">
                                    <input id="nutrition_time" name="nutrition_time" value="dinner" style="display: none">
                                    <textarea id="nutrition_description" name="nutrition_description" class="textArea">${nutrition.dinnerNutrition}</textarea>
                                    <input class="button" type="submit" value="${save}">
                                    <h3 style="position: absolute;margin-top: -30px;margin-left: 120px;">${max_symbols} ${max_number_symbols_attribute}</h3>
                                </form>
                            </div>
                        </div>
                        <label for="modal" class="buttonSub " style="color: white;text-align: center;margin-top: 10px;padding-top: 15px;width: 80px;height: 30px;font: 14px Tahoma, sans-serif;background: #29c5e6">${update}</label>
                    </c:otherwise>
                </c:choose>
            </div>

        </div>
    </section>
</div>
</body>
<c:if test="${incorrect_input_nutrition_data_error eq true}">
    <script>notifyAboutInvalidData('${incorrect_data}')</script>
</c:if>
</html>

