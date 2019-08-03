<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="text" var="text"/>

<fmt:message bundle="${text}" key="coach.current_coach" var="current_coach"/>
<fmt:message bundle="${text}" key="nutrition.max_symbols" var="max_symbols"/>
<fmt:message bundle="${text}" key="nutrition.save" var="save"/>
<fmt:message bundle="${text}" key="exercises.buy" var="buy"/>
<fmt:message bundle="${text}" key="coach.cant_choose" var="cant_choose"/>
<fmt:message bundle="${text}" key="coach.choose_coach" var="choose_coach"/>
<fmt:message bundle="${text}" key="coach.comment" var="your_comment"/>
<fmt:message bundle="${text}" key="comment.incorrect_comment_data" var="incorrect_data"/>

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
    <link rel="stylesheet" href="../../../web/styless/coach/coachesStyles.css" type="text/css">
    <link rel="stylesheet" href="../../../web/styless/buyGymMembershipStyles.css" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Staatliches" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Oswald:300" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
    <script src="../../../web/scripts/notification.js"></script>

</head>
<body>
<div id="wrapper">
    <jsp:include page="../menu.jsp">
        <jsp:param name="pageTopic" value="coaches"/>
        <jsp:param name="currentPage" value="coaches"/>

    </jsp:include>
    <section>
        <div class="container">
            <div class="rightcolumn">
                <ul>
                    <c:choose>
                        <c:when test="${is_membership_valid == true}">
                            <c:choose>
                                <c:when test="${coach_client_id!=null}">
                                    <c:forEach items="${coaches}" var="coach">
                                        <div>
                                            <c:choose>
                                                <c:when test="${coach_client_id==coach.id}">
                                                    <div class="flex-container">
                                                        <div class="flex-item flex-text">
                                                            <li class="coach" style="margin-left: 35px;"><c:out
                                                                    value="${coach.name} ${coach.surname}(${current_coach})"/></li>
                                                        </div>
                                                        <div class="flex-item">
                                                            <input class="modal__check" type="checkbox" id="modal"/>
                                                            <div class="modal">
                                                                <label class="modal__closetwo" for="modal"></label>
                                                                <div class="modal__info">
                                                                    <label class="modal__close"
                                                                           for="modal">&times;</label>
                                                                    <form name="form"
                                                                          action="${pageContext.request.contextPath}/controller?command=add_comment"
                                                                          method="post">
                                                                        <input name="coach_id" value="${coach.id}"
                                                                               style="display: none;"/>
                                                                        <h2 style="color: black;font: 25px 'Oswald', sans-serif; margin-top: -5px">${your_comment}</h2>
                                                                        <textarea id="commentContent"
                                                                                  name="commentContent"
                                                                                  class="textArea"></textarea>
                                                                        <input class="button" type="submit"
                                                                               value="${save}"
                                                                               style="margin-top: 10px;margin-right: 580px;color: #516b9e;">
                                                                        <h3 style="position: absolute;margin-top: -30px;margin-left: 120px;color: black;">${max_symbols} ${max_number_symbols_attribute}</h3>
                                                                    </form>
                                                                </div>
                                                            </div>
                                                            <label for="modal"><img class="update"
                                                                                    src="../../../web/images/comment.png"
                                                                                    height="40px" width="40px"
                                                                                    border="0" title="comment coach"
                                                                                    style=" padding-top: 15px;margin-left: -280px;">
                                                            </label>
                                                        </div>
                                                        <div class="flex-item">
                                                            <form action="${pageContext.request.contextPath}/controller?command=reject_coach"
                                                                  method="post">
                                                                <input id="coachId" name="coachId" value="${coach.id}"
                                                                       style="display: none">
                                                                <button type="submit" style="display: contents;"><img
                                                                        src="../../../web/images/rejectCoach.png"
                                                                        width="40" height="40" alt="Choose coach"
                                                                        title="Choose coach"
                                                                        style="display: inline;margin-left: -300px;">
                                                                </button>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </c:when>
                                                <c:otherwise>
                                                    <li class="coach"><c:out
                                                            value="${coach.name} ${coach.surname} "/></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <h2 style="color: black;font: 25px 'Oswald', sans-serif; margin-top: -5px;margin-left: 170px;">${choose_coach}</h2>
                                    <c:forEach items="${coaches}" var="coach">
                                        <div>
                                            <div class="flex-container">
                                                <div class="flex-item" style="margin-left: 20px; width: 130px">
                                                    <li class="coach"><c:out
                                                            value="${coach.name} ${coach.surname}"/></li>
                                                </div>
                                                <div class="flex-item">
                                                    <form action="${pageContext.servletContext.contextPath}/controller?command=choose_coach"
                                                          method="post">
                                                        <input id="coachId" name="coachId" value="${coach.id}"
                                                               style="display: none">
                                                        <button type="submit" style="display: contents;"><img
                                                                src="../../../web/images/acceptCoach.png" width="40"
                                                                height="40" alt="Choose coach" title="Choose coach"
                                                                style="display: inline"></button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        </c:when>
                        <c:otherwise>
                            <div class="flex-container" style="margin-left: -70px;">
                                <div class="flex-item" style="color:#516b9e;width:500px;">
                                    <h3>${cant_choose}</h3>
                                </div>
                                <div class="flex-item" style="margin-top: -10px; margin-left: -15px;">
                                    <form action="${pageContext.servletContext.contextPath}/controller?command=get_order_page"
                                          method="post">
                                        <input type="submit" class="button" style="color: white; text-align: center; margin: 10px 15px 5px -10px;width: 80px; height: 50px; font: 14px Tahoma, sans-serif; background: #29c5e6;
" value="${buy}">
                                    </form>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </section>
</div>
</body>

<c:if test="${incorrect_input_comment_data_error eq true}">
    <script>notifyAboutInvalidData('${incorrect_data}')</script>
</c:if>
<c:if test="${incorrect_coach_id_format_error eq true}">
    <script>notifyAboutInvalidData('Incorrect coach id format data was input')</script>
</c:if>
<c:if test="${not_exist_coach_id_error eq true}">
    <script>notifyAboutInvalidData('Coach with such id doesnt exist')</script>
</c:if>
</html>
