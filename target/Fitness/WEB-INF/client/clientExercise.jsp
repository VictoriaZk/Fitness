<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="text" var="text"/>

<fmt:message bundle="${text}" key="exercises.cant_choose_membership" var="cant_choose_membership"/>
<fmt:message bundle="${text}" key="exercises.buy" var="buy"/>
<fmt:message bundle="${text}" key="exercises.add.repeats_setnumber.title" var="title"/>
<fmt:message bundle="${text}" key="exercises.train_day" var="exercise_day"/>
<fmt:message bundle="${text}" key="exercises.edit" var="edit"/>
<fmt:message bundle="${text}" key="exercises.set_number" var="setNumber"/>
<fmt:message bundle="${text}" key="exercises.repeats" var="repeatsNumber"/>
<fmt:message bundle="${text}" key="exercises.update" var="update"/>
<fmt:message bundle="${text}" key="exercises.add_exercise" var="add_exercise"/>
<fmt:message bundle="${text}" key="exercises.enter_name" var="enter_name"/>
<fmt:message bundle="${text}" key="exercises.description" var="description"/>
<fmt:message bundle="${text}" key="exercises.add" var="add"/>
<fmt:message bundle="${text}" key="exercise.incorrect_exercise_data" var="exercise_incorrect_exercise_data"/>
<fmt:message bundle="${text}" key="exercise.incorrect_exercise_id" var="exercise_incorrect_exercise_id"/>
<fmt:message bundle="${text}" key="exercise.not_exist" var="exercise_not_exist"/>

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
    <link href="https://fonts.googleapis.com/css?family=Oswald:300" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
    <script src="../../../web/scripts/buttonStyleChanger.js"></script>
    <script src="../../../web/scripts/gymPeriodSetters.js"></script>
    <script src="../../../web/scripts/ajax/ajaxConnections.js"></script>
    <script src="../../../web/scripts/ajax/ajaxRequest.js"></script>
    <script src="../../../web/scripts/validation/exerciseValidation.js"></script>
    <script src="../../../web/scripts/notification.js"></script>

</head>
<body>
<div id="wrapper">
    <jsp:include page="../menu.jsp">
        <jsp:param name="pageTopic" value="exercises"/>
        <jsp:param name="currentPage" value="show_client_exercises"/>
    </jsp:include>
    <section>

        <div class="container">
            <div class="rightcolumn">
                <c:choose>
                    <c:when test="${is_membership_valid == false}">
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
                        <jsp:useBean id="program" type="com.epam.fitness.model.Program" scope="request"/>
                        <input id="programIdBlock" value="${program.id}" style="display: none;">
                        <div class="tabs">
                            <c:forEach var = "i" begin = "1" end = "${program.trainsPerWeek}">
                                <input class="tabs__tab" type="radio" id="tabs__tab${i}" onclick="setCurrentTrainDayInForm('${i}')" name="tabstab" style="display: none;" checked="checked"/>
                                <label class="tabs__title" for="tabs__tab${i}">${exercise_day} <c:out value="${i}"/></label>
                                <div class="tabs__text" style="overflow-y: scroll;max-height: 340px;">
                                    <ul>
                                        <c:forEach items="${exercises}" var="exerciseDto">
                                            <c:if test="${exerciseDto.numberTrainDay==i}">
                                                <div class="flex-container">
                                                    <div class="flex-item flex-text">
                                                        <c:out value="${exerciseDto.exercise.name}(${exerciseDto.setNumber},${exerciseDto.repeatNumber})"/>
                                                    </div>
                                                    <div class="flex-item ">
                                                        <input class="modal__check" type="checkbox" id="modal${exerciseDto.id}"/>
                                                        <div class="modal">
                                                            <label class="modal__closetwo" for="modal${exerciseDto.id}"></label>
                                                            <div class="modal__info">
                                                                <label class="modal__close" for="modal${exerciseDto.id}">&times;</label>
                                                                <h2 class="edit" style="color: white;">${edit}</h2>
                                                                <form action="${pageContext.request.contextPath}/controller?command=update_exercise" method="post">
                                                                    <div class="col-25" style="margin-left: -11px;">
                                                                        <label for="set_number">${setNumber}</label>
                                                                    </div>
                                                                    <div class="col-75">
                                                                        <input type="text" id="set_number" style="width: 101%;" title="${title}" name="set_number">
                                                                    </div>
                                                                    <div class="col-25" style="margin-left: -31px;">
                                                                        <label for="repeatsUpdate" style="margin-left: 10px;margin-top: 5px;">${repeatsNumber}</label>
                                                                    </div>
                                                                    <div class="col-75">
                                                                        <input type="text"  style="width: 101%; margin-left: 20px;;" id="repeatsUpdate" title="${title}"  name="repeats">
                                                                    </div>
                                                                    <input id="exerciseDtoId" name="exerciseDtoId" value="${exerciseDto.id}" style="display: none">
                                                                    <input type="submit" onclick="checkUpdateExerciseData()" class="buttonSub" value="${update}" id="update" style="margin-top: 10px;width: 80px;">
                                                                </form>
                                                            </div>
                                                        </div>
                                                        <label for="modal${exerciseDto.id}"  style="width: 60px;
                                                    height: 22px;padding-top: 10px;"><img class="update" src="../../../web/images/update.png" height="40px" width="40px" border="0"></label>
                                                    </div>
                                                    <div class="flex-item delete">
                                                        <p>
                                                            <form action="${pageContext.request.contextPath}/controller?command=delete_exercise" method="post">
                                                                <input id="exerciseDtoId" name="exerciseDtoId" value="${exerciseDto.id}" style="display: none;">
                                                                <button type="submit" style="display: contents;"><img src="../../../web/images/delete.jpg" width="40" height="40" alt="Удалить" style="display: inline"></button>
                                                            </form>
                                                        </p>
                                                    </div>
                                                </div>
                                            </c:if>
                                        </c:forEach>
                                    </ul>
                                </div>

                            </c:forEach>
                        </div>
                        <input class="modal__check" type="checkbox" id="modal"/>
                        <div class="modal">
                            <label class="modal__closetwo" for="modal"></label>
                            <div class="modal__info" style="width: 80%;max-width: 900px;max-height: 1500px;min-height: 500px">
                                <label class="modal__close" for="modal">&times;</label>
                                <input type="search"  oninput="makeRequest()" placeholder="${enter_name}" name="searchType" id="searchType" style="width: 40%;border-radius: 4px 4px 4px 4px;height: 30px;font: 20px 'Oswald', sans-serif;">
                                <hr style="margin-left: -20px;width: 110%;">
                                <form name="form" class="beatForm" action="${pageContext.request.contextPath}/controller?command=add_exercise" method="post">
                                    <input id="trainDay" name="trainDay" value="${program.trainsPerWeek}" style="display: none;">
                                    <div id="reg" >
                                        <div class="flex-container-iter" id="flex-container">
                                            <div class="flex-item" id="flex-item" >
                                                <h2 id="exerciseName" style="background: #29c5e6;font: 13px 'Oswald', sans-serif;color: #fff;padding: 10px;margin: 20px 0 0 0;border-radius: 15px 15px 0 0;width: 190px;min-height: 40px;"></h2>
                                                <p>
                                                    <img id="img" width="250" height="181" style="margin-top:-20px;width: 210px;height: 150px;" alt="Our offices">
                                                </p>
                                                <div class="flex-container" style="margin-top: -30px;">
                                                    <div class="flex-item">
                                                        <input class="modal__check" type="checkbox" id="modal{exercise.id}"/>
                                                        <div class="modal">
                                                            <label class="modal__closetwo" for="modal{exercise.id}"></label>
                                                            <div class="modal__info">
                                                                <label class="modal__close" for="modal{exercise.id}">&times;</label>
                                                                <h2 class="edit">${description}</h2>
                                                                <h3 id="description" style="color: black;text-align: left;font-weight: normal;"></h3>
                                                            </div>
                                                        </div>
                                                        <label for="modal{exercise.id}"  style="width: 60px;
                                                    height: 22px;padding-top: 10px;"><img class="update" src="../../../web/images/description.jpg" height="40px" width="40px" style="margin-left: 50px;height: 50px;width: 40px;" border="0"></label>

                                                    </div>
                                                    <div class="flex-item" style="margin-left: 20px;">
                                                        <input class="modal__check" type="checkbox" id="modalChoose{exercise.id}"/>
                                                        <div class="modal">
                                                            <label class="modal__closetwo" for="modalChoose{exercise.id}"></label>
                                                            <div class="modal__info" style="width: 1000px;height: 140px;padding-top: 40px;">
                                                                <label class="modal__close" for="modalChoose{exercise.id}">&times;</label>
                                                                <div class="exercise">
                                                                    <h2 style="text-align: center; margin-top: -35px;color: black;">${add_exercise}</h2>
                                                                    <div class="col-25">
                                                                        <label for="set_number" style="margin-top: 5px;margin-left: -140px;">${setNumber}</label>
                                                                    </div>
                                                                    <div class="col-75">
                                                                        <input  id="setNumber{exercise.id}" style="margin-left: -120px;width: 618px;" title="${title}"   type="text">
                                                                    </div>

                                                                    <div class="col-25">
                                                                        <label for="set_number" style="margin-top: 5px;margin-left: -125px;">${repeatsNumber}</label>
                                                                    </div>
                                                                    <div class="col-75">
                                                                        <input   id="repeats{exercise.id}"  style="margin-left: -120px;width: 618px;" title="${title}" type="text">
                                                                    </div>
                                                                </div>
                                                                <input type="submit" class="buttonSub" onclick="setExerciseProgram('{exercise.id}',${program.id})" title="1-2 number" style="margin-top: 10px;" value="${add}">
                                                            </div>
                                                        </div>
                                                        <label for="modalChoose{exercise.id}"  style="width: 60px;
                                                    height: 22px;padding-top: 10px;"><img class="update" src="../../../web/images/choose.jpg" height="40px" width="40px" style="margin-left: 8px;height: 50px;width: 40px;" border="0"></label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <br/>
                                </form>
                            </div>
                        </div>
                        <label for="modal" class="buttonSub" onclick="makeRequest()" style="color: white;text-align: center;margin-top: 10px;padding-top: 10px;padding-bottom: 7px;width: 80px;height: 30px;font: 14px Tahoma, sans-serif;background: #29c5e6">${add_exercise}</label>

                    </c:otherwise>
                </c:choose>
                </div>

        </div>
    </section>
</div>
<c:if test="${incorrect_input_data_error eq true}">
    <script>notifyAboutInvalidData('${exercise_incorrect_exercise_data}. ${title}')</script>
</c:if>
<c:if test="${invalid_exercise_id_format eq true}">
    <script>notifyAboutInvalidData(${exercise_incorrect_exercise_id})</script>
</c:if>
<c:if test="${not_exist_exercise_id eq true}">
    <script>notifyAboutInvalidData(${exercise_not_exist})</script>
</c:if>

</body>
</html>



