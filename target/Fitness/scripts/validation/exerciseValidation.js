function checkInputExerciseData(inputId){
    var input = document.getElementById(inputId);
    if(!/^[1-9]{1,2}$/.test(input.value) || input===''){
        var placeholderErrorText= input.getAttribute("title");
        input.setCustomValidity(placeholderErrorText);
    }else{
        input.setCustomValidity('');
    }
}

function checkUpdateExerciseData(){
    checkInputExerciseData('set_number');
    checkInputExerciseData('repeatsUpdate');
}
