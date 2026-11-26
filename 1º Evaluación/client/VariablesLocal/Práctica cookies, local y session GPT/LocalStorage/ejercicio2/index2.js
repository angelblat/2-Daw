// Utilizar cookies para recordar el nombre de un usuario pero solo 60 segundos

const btn = document.getElementById("btn-nombre");

btn.addEventListener("click", guardarNombre);
comprobarExisteCookie();
document.cookie = "nombreUsuario=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";


function guardarNombre(){
    const nombre = document.getElementById('nombre').value;
    if (nombre.trim() === "") {
        alert("No has introducido ningún nombre");
    } else {
        console.log(nombre);
        document.cookie = `nombreUsuario=${nombre}; max-age=60; path=/`;
        console.log(document.cookie);
        comprobarExisteCookie();
    }

}

function comprobarExisteCookie(){
    if (document.cookie.includes("nombreUsuario")) {
        const partes = document.cookie.split("=");
        const nombreCookie = partes[1];
        alert(`La cookie existe, el usuario es ${nombreCookie}`)
    } else {
        alert("No existe ninguna cookie");
    }
}


/*
function borrarTodasLasCookies() {
    // Obtiene la cadena con todas las cookies separadas por punto y coma
    const cookies = document.cookie.split(";");

    for (let i = 0; i < cookies.length; i++) {
        const cookie = cookies[i];
        const eqPos = cookie.indexOf("=");
        // Obtiene el nombre de la cookie eliminando los espacios en blanco
        const name = eqPos > -1 ? cookie.substring(0, eqPos).trim() : cookie.trim();

        // Asigna el nombre de la cookie con una fecha pasada y ruta raíz
        document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 UTC;path=/;";
    }
}

// Ejecutar la función
borrarTodasLasCookies();
*/