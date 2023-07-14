
window.onload = function(){
	myMap = L.map('mapid').setView([49.250723, 7.377122], 13);
	L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 40,
    attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
}).addTo(myMap);
}


function registrieren () {
	document.querySelector("#registrieren").style.display = "flex";
}

function abr_registrieren(){
	document.querySelector("#registrieren").style.display = "none";
}
	