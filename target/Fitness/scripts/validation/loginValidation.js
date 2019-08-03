function checkLogin() {
    var input = document.getElementById("login");
    if(!/^[a-zA-Z][a-zA-Z\d-_.]{1,20}$/.test(input.value)){
        var placeholderErrorText= input.getAttribute("title");
        input.setCustomValidity(placeholderErrorText);
    }else{
        input.setCustomValidity('');
    }
}

function checkPassword() {
    var inputPassword = document.getElementById("password");
    if(inputPassword.value===""){
        var passwordErrorText = inputPassword.getAttribute("title");
        inputPassword.setCustomValidity(passwordErrorText);
    }else{
        inputPassword.setCustomValidity('');
    }
}

function checkForEnterAnyData() {
    var inputLogin = document.getElementById("login");
    if(inputLogin.value===""){
        var placeholderErrorText= inputLogin.getAttribute("title");
        inputLogin.setCustomValidity(placeholderErrorText);
    }
    var inputPassword = document.getElementById("password");
    if(inputPassword.value===""){
        var passwordErrorText = inputPassword.getAttribute("title");
        inputPassword.setCustomValidity(passwordErrorText);
    }else{
        inputPassword.setCustomValidity('');
    }
}

function checkForRegistrationAnyData(){
    var loginRegisterInput = document.getElementById("login_register");
    if(loginRegisterInput.value==="" || (!/^[a-zA-Z][\w\d-_.]{2,20}$/.test(loginRegisterInput.value))){
        var loginRegisterTitle = loginRegisterInput.getAttribute("title");
        loginRegisterInput.setCustomValidity(loginRegisterTitle);
    }else{
        loginRegisterInput.setCustomValidity('');
    }

    var passwordRegisterInput = document.getElementById("password_register");
    if(passwordRegisterInput.value==="" || (!/[\w\d-_\.]{3,20}/.test(passwordRegisterInput.value))){
        var passwordRegisterTitle = passwordRegisterInput.getAttribute("title");
        passwordRegisterInput.setCustomValidity(passwordRegisterTitle);
    }else{
        passwordRegisterInput.setCustomValidity('');
    }

    var nameRegisterInput = document.getElementById("name_register");
    if(nameRegisterInput.value==="" || (!/^[a-zA-Z]{3,20}$/.test(nameRegisterInput.value))){
        var nameRegisterTitle = nameRegisterInput.getAttribute("title");
        nameRegisterInput.setCustomValidity(nameRegisterTitle);
    }else{
        nameRegisterInput.setCustomValidity('');
    }

    var surnameRegisterInput = document.getElementById("surname_register");
    if(surnameRegisterInput.value==="" || (!/^[a-zA-Z]{3,20}$/.test(surnameRegisterInput.value))){
        var surnameRegisterTitle = surnameRegisterInput.getAttribute("title");
        surnameRegisterInput.setCustomValidity(surnameRegisterTitle);
    }else{
        surnameRegisterInput.setCustomValidity('');
    }

}