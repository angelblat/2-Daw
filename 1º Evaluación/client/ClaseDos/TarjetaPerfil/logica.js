const botonDatos = document.getElementById("boton-datos");
const botonImagen = document.getElementById("boton-imagen");
const botonTema = document.getElementById("boton-tema");
const botonTodo = document.getElementById("boton-todo");


const cambiarDatos = () =>{
    const nombre = document.getElementById("nombre-usuario");
    const descripcion = document.getElementById("descripcion-usuario");

    const nombreArray = ["Roberto", "Angel", "Alberto", "Maria", "Claudia"];
    let aleatorio = Math.floor(Math.random() * nombreArray.length);
    let nombreFinal = nombreArray[aleatorio];

    const loremArray = [
        "Lorem ipsum dolor sit amet",
        "Consectetur adipiscing elit do",
        "Eiusmod tempor incididunt ut",
        "Labore et dolore magna",
        "Aliqua ut enim ad"
    ];

    const descripcionFinal = loremArray[aleatorio];

    while (nombre.innerText === nombreFinal){
        aleatorio = Math.floor(Math.random() * nombreArray.length);
        nombreFinal = nombreArray[aleatorio];
    }

    document.getElementById("nombre-usuario").innerText = nombreFinal;
    document.getElementById("descripcion-usuario").innerText = descripcionFinal;
    console.log("Los datos han sido modificados")
    console.log("El nombre seleccionado es: ", nombreFinal);


}

botonDatos.addEventListener("click", cambiarDatos);

botonImagen.addEventListener("click", function() {
    const imagen = document.getElementById("foto-perfil");
    imagen.src = "https://picsum.photos/200?"+Date.now();

    console.log("Imagen de perfil modificada");

    // Tambien se puede hacer con imagen.setAttribute("src", "linkImagen.com");
});

const colores = [
    "white", "black", "gray", "darkgray", "lightgray", "silver", "gold",
    "red", "crimson", "crimson", "maroon", "pink", "lightpink", "fuchsia", "magenta",
    "blue", "navy", "royalblue", "skyblue", "lightblue", "turquoise", "cyan", "indigo",
    "green", "lime", "mintcream", "olive", "seagreen", "darkgreen", "honeydew",
    "yellow", "lightyellow", "gold", "amber", "orange", "coral", "salmon",
    "purple", "violet", "lavender", "purple", "lavender", "orchid",
    "brown", "saddlebrown", "chocolate", "beige", "cornsilk", "bisque", "peru", "sienna"
];


function obtenerColorAleatorio(listaDeColores) {
    const indiceAleatorio = Math.floor(Math.random() * listaDeColores.length);
    return listaDeColores[indiceAleatorio];
}


botonTema.addEventListener("click", function(){
    let colorSuerte = obtenerColorAleatorio(colores);
    const tarjeta = document.getElementById("tarjeta-perfil");
    tarjeta.style.backgroundColor = colorSuerte;
    colorSuerte = obtenerColorAleatorio(colores);
    const nombre = document.getElementById("nombre-usuario");
    nombre.style.color = colorSuerte;
    console.log("Tu color aleatorio es:", colorSuerte);
});


botonTodo.addEventListener("click", function() {
    botonTema.click();
    botonImagen.click();
    botonDatos.click();
});

