function setCurrentTrainDayInForm(day) {
    document.getElementById("trainDay").value = day;
}

function setExerciseProgram(exerciseId, programId) {
    createCheckAndSetNumberInput(exerciseId);
    createRepeatsInput(exerciseId);
    createExerciseIdInput(exerciseId);
    createProgramIdInput(programId);
}

function createCheckAndSetNumberInput(exercise) {
    var setNumber = document.getElementById("setNumber"+exercise).value;
    var newSetNumberInput = document.createElement('input');
    newSetNumberInput.style.display="none";
    newSetNumberInput.name = "set_number";
    newSetNumberInput.value = setNumber;
    document.form.appendChild(newSetNumberInput);
}

function createRepeatsInput(exercise) {
    var repeats = document.getElementById("repeats"+exercise).value;
    var newRepeatsInput = document.createElement('input');
    newRepeatsInput.style.display="none";
    newRepeatsInput.name = "repeats";
    newRepeatsInput.value = repeats;
    document.form.appendChild(newRepeatsInput);
}

function createExerciseIdInput(exerciseId) {
    var newExerciseIdInput = document.createElement('input');
    newExerciseIdInput.style.display="none";
    newExerciseIdInput.name = "exerciseId";
    newExerciseIdInput.value = exerciseId;
    document.form.appendChild(newExerciseIdInput);
}

function createProgramIdInput(programId) {
    var newProgramIdInput = document.createElement('input');
    newProgramIdInput.style.display="none";
    newProgramIdInput.name = "programId";
    newProgramIdInput.value = programId;
    document.form.appendChild(newProgramIdInput);
}