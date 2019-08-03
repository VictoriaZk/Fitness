<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="text" var="text"/>

<fmt:message bundle="${text}" key="about_us" var="abous_us"/>
<fmt:message bundle="${text}" key="about_gym" var="about_gym"/>
<fmt:message bundle="${text}" key="quote_author" var="quote_author"/>
<fmt:message bundle="${text}" key="our_team" var="our_team"/>
<fmt:message bundle="${text}" key="reason" var="reason"/>
<fmt:message bundle="${text}" key="first_reason" var="first_reason"/>
<fmt:message bundle="${text}" key="second_reason" var="second_reason"/>
<fmt:message bundle="${text}" key="why_preference" var="why_preference"/>
<fmt:message bundle="${text}" key="variety_choise" var="varierty_choise"/>
<fmt:message bundle="${text}" key="individual_approach" var="individual_approach"/>
<fmt:message bundle="${text}" key="instructors" var="instructors"/>
<fmt:message bundle="${text}" key="stay" var="stay"/>
<fmt:message bundle="${text}" key="prices" var="prices"/>
<fmt:message bundle="${text}" key="location" var="location"/>
<fmt:message bundle="${text}" key="variety_choise_text" var="variety_choise_text"/>
<fmt:message bundle="${text}" key="individual_approach_text" var="individual_approach_text"/>
<fmt:message bundle="${text}" key="instructors_text" var="instructors_text"/>
<fmt:message bundle="${text}" key="stay_text" var="stay_text"/>
<fmt:message bundle="${text}" key="prices_text" var="prices_text"/>
<fmt:message bundle="${text}" key="location_text" var="location_text"/>
<fmt:message bundle="${text}" key="manager" var="manager"/>
<fmt:message bundle="${text}" key="art_director" var="art_director"/>
<fmt:message bundle="${text}" key="administrator" var="administrator"/>
<fmt:message bundle="${text}" key="spa_administrator" var="spa_administrator"/>
<fmt:message bundle="${text}" key="masseur" var="masseur"/>
<fmt:message bundle="${text}" key="main_coach" var="main_coach"/>


<!doctype html>
<html lang="${sessionScope.language}">
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>Fitness-centre</title>
    <link rel="stylesheet" href="../styless/baseStyles.css" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Staatliches" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Noto+Serif+TC" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Oswald:300" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato|Sarabun" rel="stylesheet">
    <script src="../scripts/buttonStyleChanger.js"></script>
    <script src="../scripts/notification.js"></script>


</head>
<body>
<div id="wrapper">
    <jsp:include page="menu.jsp">
        <jsp:param name="pageTopic" value="about_us"/>
        <jsp:param name="currentPage" value="main"/>
    </jsp:include>
    <section>
        <blockquote style="margin-top: 0px;">
            <p>${about_gym}</p>
            <cite>${quote_author}</cite>
        </blockquote>
        <div class="block" style="height:405px;overflow-y: scroll; margin-top:20px;">
            <div class="myText" style="width: 640px;margin-left: 20px;">
                <h2 style="text-align: center;padding-top: 10px;font-family: 'Sarabun', sans-serif;">${reason}</h2>
                <p class="textP">${first_reason}</p>
                <p class="textP">${second_reason}</p>
                <h2 style="text-align:left;padding-top: 10px;font-family: 'Sarabun', sans-serif;">${why_preference}</h2>
                <div style="margin-left: -15px;">
                    <ul>
                        <li>
                            <p class="textP"><b>${varierty_choise}</b>${variety_choise_text}</p>
                        </li>
                        <li>
                            <p class="textP"><b>${individual_approach}</b>${individual_approach_text}</p>
                        </li>
                        <li>
                            <p class="textP"><b>${instructors}</b>${instructors_text}</p>
                        </li>
                        <li>
                            <p class="textP"><b>${stay}</b>${stay_text}</p>
                        </li>
                        <li>
                            <p class="textP"><b>${prices}</b>${prices_text}</p>
                        </li>
                        <li>
                            <p class="textP"><b>${location}</b>${location_text}</p>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <figure>
            <img src="../images/zal1.jpg" style="margin-top: 15px;" width="320" height="175" alt="">
        </figure>
        <figure>
            <img src="../images/zal2.jpg" width="320" height="175" style="margin-left: 35px" alt="">
        </figure>

        <h2>${our_team}</h2>
        <div class="team-row">
            <figure>
                <img src="../images/workers/ceo.jpg" width="136" height="96" alt="">
                <figcaption>John Doe <span>${manager}</span></figcaption>
            </figure>
            <figure>
                <img class="tabImage" src="../images/workers/artDirecor.jpg" width="120" height="96" alt="">
                <figcaption class="tabGrip">Ericka Nobriga <span>${art_director}</span></figcaption>
            </figure>
            <figure>
                <img class="tabImage" src="../images/workers/administrator.jpg" width="137" height="96" alt="">
                <figcaption class="tabGrip">Saundra Pittsley <span>${administrator}</span></figcaption>
            </figure>
            <figure>
                <img class="tabImage" src="../images/workers/administrator2.jpg" width="134" height="96" alt="">
                <figcaption class="tabGrip">Margery Venuti <span>${spa_administrator}</span></figcaption>
            </figure>
        </div>
        <div class="team-row">

            <figure>
                <img src="../images/workers/administrator1.jpg" width="120" height="96" alt="">
                <figcaption>Julio Simser <span>${administrator}</span></figcaption>
            </figure>
            <figure>
                <img class="tabImage" src="../images/workers/mass.jpg" width="136" height="96" alt="">
                <figcaption class="tabGrip">Cody Rousselle <span>${masseur}</span></figcaption>
            </figure>
            <figure>
                <img class="tabImage" src="../images/workers/mass2.jpg" width="137" height="96" alt="">
                <figcaption class="tabGrip">Erik Wollman <span>${masseur}</span></figcaption>
            </figure>
            <figure>
                <img class="tabImage" src="../images/workers/mainCoach.jpg" width="134" height="96" alt="">
                <figcaption class="tabGrip">Dona Shoff <span>${main_coach}</span></figcaption>
            </figure>
        </div>
    </section>
</div>

<c:if test="${no_access_page_error eq true}">
    <script>notifyAboutInvalidData('No access from this page')</script>
</c:if>
</body>
</html>