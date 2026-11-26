document.addEventListener("DOMContentLoaded", function(){

console.log("El DOM esta listo para usarse.")

let boton = document.querySelector("button");
boton.addEventListener("click", clickPulsado); 


});

const clickPulsado = () => {

    
let botonMuestraNombre = document.querySelector("button");

let nombre = document.getElementById("respuesta").value.trim();
if (nombre === "") {
    console.log("Por favor, rellena el campo");
    let resumenAnterior = document.querySelector(".texto1");

    if (resumenAnterior !== null) {
        resumenAnterior.remove();
    }
} else {
    console.log("Nombre guardado con éxito.")

    let resumenAnterior = document.querySelector(".texto1");

    if (resumenAnterior !== null) {
        resumenAnterior.remove();
    }

    botonMuestraNombre.insertAdjacentHTML("afterend", `<div class="texto1"><p><strong>Resumen del valor recogido</strong></p>
        <p>${nombre}</p></div>`);
}
};