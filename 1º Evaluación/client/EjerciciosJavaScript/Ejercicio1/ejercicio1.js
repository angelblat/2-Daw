const parrafo = document.getElementById("saludo-dinamico");

const fecha = new Date();
const hora = fecha.getHours();
const minutos = fecha.getMinutes();

const resultado = minutos < 10 ? `Son las ${hora}:0${minutos}` : `Son las ${hora}:${minutos}`;

if (hora < 12) {
    parrafo.innerHTML = "Buenos días";
    parrafo.innerHTML += `<p>${resultado}</p>`;
} else if (hora < 18) {
    parrafo.innerHTML = "Buenas tardes";
    parrafo.innerHTML += `<p>${resultado}</p>`;
} else {
    parrafo.innerHTML = "Buenas noches";
    parrafo.innerHTML += `<p>${resultado}</p>`;
} 