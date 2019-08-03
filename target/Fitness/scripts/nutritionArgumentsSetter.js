function setArguments(time) {
    document.getElementById('nutrition_description').innerHTML = document.getElementById(time).innerHTML;
    document.getElementById('nutrition_time').value = time;
}