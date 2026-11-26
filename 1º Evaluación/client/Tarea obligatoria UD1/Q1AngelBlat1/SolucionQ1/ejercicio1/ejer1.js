document.addEventListener("DOMContentLoaded", function(){

console.log("El DOM esta listo para usarse.")

const boton = document.querySelector("button");
boton.addEventListener("click", clickPulsado);

});

const clickPulsado = () => {
    const texto = document.querySelector("p");
    texto.style.visibility = "visible";
}