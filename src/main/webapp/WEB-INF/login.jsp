<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="text" var="text"/>

<fmt:message bundle="${text}" key="login.username.placeholder" var="username_placeholder"/>
<fmt:message bundle="${text}" key="login.pattern.error" var="username_pattern_error"/>
<fmt:message bundle="${text}" key="login.password.placeholder" var="password_placeholder"/>
<fmt:message bundle="${text}" key="login.password.error" var="password_pattern_error"/>
<fmt:message bundle="${text}" key="login.enter" var="enter"/>
<fmt:message bundle="${text}" key="login.registration" var="registration"/>
<fmt:message bundle="${text}" key="login.username" var="username"/>
<fmt:message bundle="${text}" key="login.password" var="password"/>
<fmt:message bundle="${text}" key="name" var="name"/>
<fmt:message bundle="${text}" key="surname" var="surname"/>
<fmt:message bundle="${text}" key="login.name.placeholder" var="name_placeholder"/>
<fmt:message bundle="${text}" key="login.surname.placeholder" var="surname_placeholder"/>

<!DOCTYPE html>
<html lang="${sessionScope.language}" >

  <meta charset="UTF-8">
  <title>Day 001 Login Form</title>
  <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans:600'>
  <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
  <link rel="stylesheet" href="../styless/loginStyles.css">
  <script src="../scripts/validation/loginValidation.js"></script>
  </head>

<body>
  <div class="login-wrap">
		<div class="login-html">
	 <div class="header">
		 <form action="${pageContext.servletContext.contextPath}/controller?command=language" method="post">
			 <input name="currentPage" value="${param.currentPage}" style="display: none;">
			 <input name="language" value="${sessionScope.nextLanguage}" style="display: none;">
			 <input type="submit" value="${sessionScope.language}" style="border: none;background: none;list-style-position: inside;font-family: 'Poppins', sans-serif;font-size: 16px;height: 40px;margin-left: 1500px;color: white">
		 </form>
	  </div>
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label style="margin-top: 50px;" for="tab-1" class="tab" >${enter}</label>
		<input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">${registration}</label>
			<div class="login-form" >
				<div class="sign-in-htm">
					<form action="${pageContext.servletContext.contextPath}/controller?command=login" method="post">
					<div class="group">
						<label for="login" class="label">${username}</label>
						<input  id="login" oninput="checkLogin()" name="login" type="text" class="input" required placeholder="${username_placeholder}" title="${username_pattern_error}">
					</div>
					<div class="group">
						<label for="password" class="label">${password}</label>
						<input  name="password" oninput="checkPassword()" id="password" type="password" class="input" placeholder="${password_placeholder}" title="${password_pattern_error}" >
					</div>
						<c:if test="${login_exist_error eq true}">
							<h3 style="color: red;margin-top: -10px;margin-left: 3px;width: 450px;font-size: 11px;">User with such login exist</h3>
						</c:if>
						<c:if test="${incorrect_login_data eq true}">
							<h3 style="color: red;margin-top: -10px;margin-left: 3px;width: 450px;font-size: 11px;">Enter invalid  format of login .Please try again
								Login pattern:2-20 characters, which can be letters and numbers, the first character is necessarily a letter
							</h3>
						</c:if>
						<c:if test="${incorrect_password_data eq true}">
							<br>
							<h3 style="color: red;margin-top: -20px;margin-left: 3px;">Please enter correct password. Minimum 3 symbols</h3>
						</c:if>
						<c:if test="${incorrect_name_surname_data eq true}">
							<br>
							<h3 style="color: red;margin-top: -20px;margin-left: 3px;">Incorrect Name or Surname.Pattern: 3-20 alphabetic characters of the Latin alphabet </h3>
						</c:if>
						<c:if test="${authentication_error eq true}">
							<br>
							<h3 style="color: red;margin-top: -20px;margin-left: 3px;">Enter invalid login or password.Please try again</h3>
						</c:if>
					<div class="group">
						<input onclick="checkForEnterAnyData()" type="submit" class="button" value="${enter}">
					</div>
					</form>
				</div>

			<div class="sign-up-htm">
					<form action="${pageContext.servletContext.contextPath}/controller?command=client_registration" method="post">
						<div class="group">
							<label for="login_register" class="label">${username}</label>
							<input id="login_register"  name="login_register" type="text" class="input" required  placeholder="${username_placeholder}" title="${username_pattern_error}">
						</div>
						<div class="group">
							<label for="password_register" class="label">${password}</label>
							<input id="password_register" name="password_register" type="password" title="minimum 3 symbols" required placeholder="${password_placeholder}"  class="input" data-type="password">
						</div>
						<div class="group">
							<label for="name_register" class="label">${name}</label>
							<input id="name_register" name="name_register" type="text" class="input" title="3-20 letters" placeholder="${name_placeholder}" required  data-type="text">
						</div>
						<div class="group">
							<label for="surname_register" class="label">${surname}</label>
							<input id="surname_register" name="surname_register" type="text" title="3-20 letters" placeholder="${surname_placeholder}" required  class="input">
						</div>

						<div class="group">
							<input type="submit" onclick="checkForRegistrationAnyData()"  class="button" value="${registration}">
						</div>
					</form>
				</div>
			</div>
	</div>
</div>
  
  

</body>

</html>
