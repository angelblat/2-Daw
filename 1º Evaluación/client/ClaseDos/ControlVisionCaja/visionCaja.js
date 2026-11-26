const caja = document.getElementById("miCaja");

caja.addEventListener("click", function() {
    this.classList.toggle("oculto");
});

const boton = document.getElementById("boton1");

boton.addEventListener("click", function() {
    caja.classList.toggle("oculto");
});