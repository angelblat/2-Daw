const botonCalcular = document.getElementById("btn-calcular");
const titulo = document.getElementById("titulo");
const seccion = document.getElementById("seccion1");


// Tus datos de partida son así:
let alumnos = [
    ["alicia", 4, 5, 8],
    ["paco", 7, 8, 5]
];

// Tus datos de partida son así:
let alumnosClase = [
    { nombre: "alicia", notas: [4, 2, 8] },
    { nombre: "paco", notas: [4, 6, 9] }
];

const lista = document.getElementById("listaAlu");

botonCalcular.addEventListener("click", calcularNotas4);


function calcularNotas(){

    lista.innerHTML = "";
    for (let x = 0; x < alumnos.length; x++){
        let sumaNotas = 0;
        let nombre = alumnos[x][0];
        let contador = 0;
        for (let y = 1; y < alumnos[x].length; y++) {
            sumaNotas += alumnos[x][y];
            contador++;
        }
        const media= (sumaNotas / contador);
        let li = document.createElement("li");
        li.textContent = `La nota media de ${nombre} es ${media.toFixed(2)}`;
        lista.appendChild(li);
    }

}

/*
function calcularNotas2 (){
    for (let x = 0; x < alumnosClase.length; x++){
        let sumaNotas=0;
        let totalNotas= alumnosClase[x].notas.length;
        for (let y = 0; y < alumnosClase[x].notas.length; y++){
            sumaNotas += alumnosClase[x].notas[y];
        }
        let notaMedia = (sumaNotas/totalNotas).toFixed(2);
        seccion.insertAdjacentHTML("beforebegin", `<p class="resultado_nota">La nota media de ${alumnosClase[x].nombre} 
        es: ${notaMedia}</p>`);
    }
}
 */


function calcularNotas2 () {

    lista.innerHTML = "";

    for (let i = 0; i < alumnosClase.length; i++) {

        let usuario = alumnosClase[i];

        let suma = usuario.notas.reduce((acumulador, nota) => acumulador + nota, 0);

        let media = suma / usuario.notas.length;

        let li = document.createElement("li");

        li.textContent = usuario.nombre + " -> Media: " + media.toFixed(2);

        lista.appendChild(li);
    }

}

function calcularNotas3 () {

    lista.innerHTML = "";

    for (let i = 0; i < alumnosClase.length; i++) {

        let usuario = alumnosClase[i];

        let suma = usuario.notas.reduce((acumulador, nota) => acumulador + nota, 0);

        let media = suma / usuario.notas.length;

        let li = document.createElement("li");

        li.textContent = usuario.nombre + " -> Media: " + media.toFixed(2);

        lista.appendChild(li);
    }

}


function calcularNotas4() {

    lista.innerHTML = "";

    alumnosClase.forEach((alumno) => {
        let media = calcularMedia(alumno.notas);

        let li = document.createElement("li");

        li.textContent = alumno.nombre + " -> Media: " + media.toFixed(2);

        lista.appendChild(li);

});




/*
*function calcularMedia(notas){
* const suma = notas.reduce((accumulador, nota) => acumulador, nota, 0);
* return suma / notas.length.
* }
*
* function obtenerAprobadas(notas){
* return notas.filter(nota => nota >= 5);
*}
*/

function calcularMedia(nota){
const suma = nota.reduce((acumulador, nota) => acumulador, nota, 0);
return suma / nota.length;
}

function filterAprob(nota) {
    return notas.filter(nota => nota <= 5);
}}




















