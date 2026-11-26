// El objetivo es recordar cuantas veces ha entrado el usuario a la página

const parrafo = document.getElementById("contador");

localStorage.getItem("visitas") ? aumentarVisita() : crearVisita();

function aumentarVisita(){
    let contador =parseInt(localStorage.getItem("visitas"));
    contador++;
    localStorage.setItem("visitas", contador);
    parrafo.innerHTML = contador;
}

function crearVisita (){
    let contador = 1;
    localStorage.setItem("visitas", contador);
    parrafo.innerHTML = contador;
    console.log("hola");
}

// localStorage.removeItem("visitas");