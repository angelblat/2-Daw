const seccion = document.getElementById("eventos");

seccion.addEventListener("mouseover", cambiaColor);

let colorOriginal;

function cambiaColor(){
    colorOriginal = window.getComputedStyle(seccion).backgroundColor;
    seccion.style.backgroundColor="#e9e9e9";
}

seccion.addEventListener("mouseout", cambiaColorOriginal);

function cambiaColorOriginal(){
    seccion.style.backgroundColor = colorOriginal;
}

/*

--- Asi es como sería para que al quitar el mouse, vuelva al color anterior.

seccion.addEventListener("mouseout", cambiaColorOriginal);

function cambiaColorOriginal(){
    seccion.style.backgroundColor="#ffffff";
}

La función window.getComputedStyle(seccion) no la conocía, la he usado a raiz de averiguarla
por el caso de no saber el color, en este caso que si lo sabemos, se podría hacer como arriba
que es como lo había hecho previamente.

*/
