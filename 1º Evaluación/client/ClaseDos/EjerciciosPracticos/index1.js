const respuesta = document.getElementById("respuesta");
const ocultador = document.getElementById("ocultador");

ocultador.addEventListener("click", function (){
   respuesta.classList.toggle("oculto");
});
