<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="text" var="text"/>

<fmt:message bundle="${text}" key="no_comments" var="no_comments"/>

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
    <link rel="stylesheet" href="../../../web/styless/coach/coachCommentStyle.css" type="text/css">
    <link rel="stylesheet" href="../../../web/styless/client/clientNutritionStyles.css" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Oswald:300" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
</head>
<body>
<div id="wrapper">
    <jsp:include page="../menu.jsp">
        <jsp:param name="pageTopic" value="show_comments"/>
        <jsp:param name="currentPage" value="show_coach_comments"/>
    </jsp:include>
    <section>
        <div class="container">
            <div class="rightcolumn" style="overflow-y: scroll; overflow-x: hidden;height: 350px;">
                <c:choose>
                    <c:when test="${fn:length(comments) eq 0}">
                        <h3 style="margin-left: 10px;"><c:out value="${no_comments}"/></h3>
                    </c:when>
                    <c:otherwise>
                        <div style="margin-top: -60px;">
                            <c:forEach var="coachComment" items="${comments}">
                                <div class="flex-container" style="padding-top: 30px;">
                                    <div class="flex-item">
                                        <img src="../../../web/images/user.png" height="100px">
                                    </div>
                                    <div class="flex-item">
                                        <h3><c:out value="${coachComment.value.name} ${coachComment.value.surname}"/></h3>
                                        <br>
                                        <h5><c:out value="${coachComment.key.commentContent}"/></h5>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>

        </div>
    </section>
</div>

</body>
</html>

