const parrafo1 = document.getElementById("parrafo1");
const parrafo2 = document.getElementById("parrafo2");
const parrafo3 = document.getElementById("parrafo3");


// Ejercicio 1

function actualizarHora1() {

    const f = num => num.toString().padStart(2, '0');

    const horaActual = new Date();
    const hora = f(horaActual.getHours());
    const minuto = f(horaActual.getMinutes());
    const segundos = f(horaActual.getSeconds());

    parrafo1.innerHTML= "Actualmente son las: " + hora + ":" + minuto + ":" + segundos;
}

actualizarHora1();

// Ejercicio 2

function actualizarHora2() {
    const f = num => num.toString().padStart(2, `0`);
    const horaActual = new Date();
    const hora = f(horaActual.getHours());
    const minuto = f(horaActual.getMinutes());
    const segundos = f(horaActual.getSeconds());
    const horaDef = `Actualmente son las: ${hora}:${minuto}:${segundos}`;

    parrafo2.innerHTML = horaDef;

    return horaDef;
}

actualizarHora2();

const bucle = setInterval(actualizarHora2, 1000);

function parar (){
    clearInterval(bucle);
    parrafo2.innerHTML = `${actualizarHora2()} (Fin)`;
}

setTimeout(parar, 5000);

// Ejercicio 3

function actualizarHora3() {

    const f = num => num.toString().padStart(2, '0');

    const horaActual = new Date();
    let hora = horaActual.getHours();
    const minuto = horaActual.getMinutes();
    const segundos = horaActual.getSeconds();
    let respuesta = "";

    if (hora===0){
        hora = 12;
        respuesta = "Am";
    } else if (hora>=12) {
        hora = hora === 12 ? 12 : hora - 12;
        respuesta = "Pm";
    } else {
        respuesta = "Am";
    }

    parrafo3.innerHTML= "Actualmente son las: " + f(hora) + ":" + f(minuto) + ":" + f(segundos) + ` ${respuesta}`;
}

actualizarHora3();

setInterval(actualizarHora3, 1000);




