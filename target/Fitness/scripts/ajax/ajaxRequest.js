
var req;

function makeRequest(){
    req = newXMLHttpRequest();
    req.onreadystatechange = getReadyStateHandler(req, addExercises);
    req.open("POST", "Ajaxcontroller", true);
    req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    var currentSearch = document.getElementById("searchType").value;
    req.send("searchArgument=" + currentSearch);
}

function addExercises(){
    if(req.readyState === 4 && req.status === 200){
        var parsed = JSON.parse(req.responseText);
        var flexItem = getFlexItemBlock();
        var flexContainer = document.getElementById('flex-container');
        flexContainer.innerHTML="";
        flexContainer.appendChild(flexItem);
        for(var i = 0; i<parsed.exercises.length; i++){
            document.getElementById('description').innerText = parsed.exercises[i].description ;
            document.getElementById("img").src =  parsed.exercises[i].image;
            document.getElementById("exerciseName").innerText =  parsed.exercises[i].name;
            var flexItemToAdd = document.getElementById('flex-item').innerHTML;
            flexItemToAdd = flexItemToAdd.replace(/{exercise.id}/g,parsed.exercises[i].id);
            var newFlexItem = document.createElement('div');
            newFlexItem.innerHTML = flexItemToAdd;
            newFlexItem.classList.add("flex-item-iter");
            newFlexItem.id='flex-item'+parsed.exercises[i].id;
            flexContainer.appendChild(newFlexItem);
        }

    }
}

function getFlexItemBlock() {
    var divText = document.getElementById('flex-item').innerHTML;
    var newFlexItem = document.createElement('div');
    newFlexItem.style.display = "none";
    newFlexItem.id='flex-item';
    newFlexItem.classList.add("flex-item");
    newFlexItem.innerHTML = divText;
    return newFlexItem;
}
