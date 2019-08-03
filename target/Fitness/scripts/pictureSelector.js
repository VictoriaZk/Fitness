function setNextPicture(id) {
    var maxIndex = 8;
    var currentInputImage;
    if(id===0){
        currentInputImage = document.getElementById("closeLabel"+maxIndex);
    }else{
        currentInputImage = document.getElementById("closeLabel"+(id-1));

    }
    currentInputImage.click();
    var nextInputImage = document.getElementById("modal"+id);
    nextInputImage.click();
}

function setPreviousPicture(id) {
    var maxIndex = 8;
    var currentInputImage;
    if(id===maxIndex){
        currentInputImage = document.getElementById("closeLabel"+0);
    }else{
        var previousIndex = id+1;
        currentInputImage = document.getElementById("closeLabel"+previousIndex);
    }
    currentInputImage.click();
    var previousInputImage = document.getElementById("modal"+id);
    previousInputImage.click();
}