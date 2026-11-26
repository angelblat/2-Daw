// Objetivo: Utilizar sessionStorage para salvar la información del usuario si la página se recarga por accidente, pero
// limpiarla si decide irse.

const cuadroTexto = document.getElementById("campoTexto");

cuadroTexto.addEventListener("input", actualizarSession);
comprobarSession();

function actualizarSession(){
    sessionStorage.setItem("textoTemporal", cuadroTexto.value);
    console.log(cuadroTexto.value);
}

function comprobarSession() {
    if (sessionStorage.getItem("textoTemporal")){
        cuadroTexto.value = sessionStorage.getItem("textoTemporal");
    } else {
        console.log("No hay ningún Session Storage");
    }
}