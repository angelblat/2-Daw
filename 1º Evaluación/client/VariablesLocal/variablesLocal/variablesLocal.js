/*
const boton1 = document.getElementById("btn_cambiarTema");

boton1.addEventListener("click", cambiarTema);

function cambiarTema(){

    const colorActual = document.body.style.backgroundColor;

    if (colorActual === "black"){
        document.body.style.backgroundColor = "white";
        localStorage.setItem("colorFondo", "white");
    } else {
        document.body.style.backgroundColor = "black";
        localStorage.setItem("colorFondo", "black");
    }
}

const colorGuardado = localStorage.setItem("colorFondo");

if (colorGuardado) {
    document.body.style.backgroundColor = colorGuardado;
}
*/

const btnTema = document.getElementById('btn_cambiarTema');
const btnCrearCookie = document.getElementById('btn_crearCookie');
const btnBorrarCookie = document.getElementById('btn_borrarCookie');
const btnLeerCookie = document.getElementById('btn_leerCookie');

document.body.className = localStorage.getItem('tema') || '';

btnTema.addEventListener('click',() => {
    document.body.classList.toggle('dark-theme');
    localStorage.setItem('tema', document.body.className);
    crearCookie();
})

btnCrearCookie.addEventListener("click", crearCookie);
btnBorrarCookie.addEventListener("click", borrarCookie);
btnLeerCookie.addEventListener("click", leerCookie);


function crearCookie() {

    var nombre = "tema";
    var valor = "oscuro";
    var valorCodificado = encodeURIComponent(valor);
    let fechaCaducidad = new Date();

    fechaCaducidad.setTime(fechaCaducidad.getTime() + (30 * 24 * 60 * 60 * 1000));
    document.cookie = "usuario=User1; expires=" + fechaCaducidad.toUTCString();

    document.cookie = nombre + "=" + valorCodificado + "; expires=" + fechaCaducidad + "; path=/";

    //Crear la cookie con Max age
    var maxAge = 30 * 24 * 60 * 60;
    document.cookie = nombre + "=" + valorCodificado + "; max-age=" + maxAge + "; path=/";

    document.getElementById("mensaje").innerHTML = "Cookie 'tema' creada."

}

function borrarCookie(){
    document.cookie = "tema=; max-age=0; path=/";
    document.cookie = "tema=; expires=Thu, 01 Jam 1970 00:00:00 GMT; path=/;"
    document.getElementById("mensaje").innerHTML = "Cookie 'tema' borrada."

}

function leerCookie(){
    if (document.cookie){
        alert(document.cookie)
    }
}




