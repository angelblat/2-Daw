var usuario = {nombre:"Borja", edad:23, ciudad: "Puçol", hobbies: ["natación", "futbol"]};

const boton = document.getElementById("btn-mostrar-perfil");
const spanNombre = document.getElementById("perfil-nombre");
const spanEdad = document.getElementById("perfil-edad");
const spanCiudad = document.getElementById("perfil-ciudad");
const spanHobbies = document.getElementById("perfil-hobbies");

const boton_pressed = addEventListener("click", mostrarDatos);

function mostrarDatos() {
 spanNombre.innerHTML = usuario.nombre;
 spanEdad.innerHTML = usuario.edad;
 spanCiudad.innerHTML = usuario.ciudad;
 for (let x = 0; x < usuario.hobbies.length; x++){
     spanHobbies.innerHTML += usuario.hobbies[x];
     if (x < usuario.hobbies.length - 1) {
         spanHobbies.innerHTML += ", ";
     }
 }
}