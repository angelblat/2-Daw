const diasSemana = ['lunes', 'martes', 'miércoles', 'jueves', 'viernes', 'sábado', 'domingo'];
const listaDias = document.getElementById("lista-dias");
const boton = document.getElementById("btn-dias");

boton.addEventListener("click", crearListaDias);

function crearListaDias() {
    listaDias.innerHTML = "";

    for (let i = 0; i < diasSemana.length; i++){
        listaDias.innerHTML += "<li>" + diasSemana[i] + "</li>";
    }
}
