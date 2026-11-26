const btnAgregar = document.getElementById("btn-Agregar");
const btnMostrar = document.getElementById("btn-Mostrar");
const btnBorrar = document.getElementById("btn-Borrar");
const btnCalcularMediaAnios = document.getElementById("btn-CalcularMediaAnios");
const lista = document.getElementById("lista");
const parrafoMediaAnios = document.getElementById("mediaAnios");
let biblioteca = [];
btnAgregar.addEventListener("click", agregarLibro);
btnMostrar.addEventListener("click", imprimirLibreria);
btnBorrar.addEventListener("click", nombreBorrar);
btnCalcularMediaAnios.addEventListener("click", calcularMediaAnios);


    function Libro(titulo, autor, genero, anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anio = anio;

        this.getTitulo = function() {
            return this.titulo;
        };

        this.mostrarInfo = function() {
            return `Título: ${this.titulo}, Autor: ${this.autor}, Año: ${this.anio}, Género: ${this.genero}`;
        };
    }

function agregarLibro() {
    let titulo = document.getElementById("titulo").value;
    let autor = document.getElementById("autor").value;
    let genero = document.getElementById("genero").value;
    let anio = parseInt(document.getElementById("anio").value);

    if (!titulo || !autor || !genero || !anio) {
        alert("Rellena todos los campos");
        return;
    }

    let libroNuevo = new Libro(titulo, autor, genero, anio);

    biblioteca.push(libroNuevo);

    console.log(libroNuevo.mostrarInfo());
    console.log(biblioteca);
}

function imprimirLibreria (){

    lista.innerHTML = biblioteca.map(libro =>{
            return `<li>${libro.mostrarInfo()}</li>`;
        });
}

function nombreBorrar () {
        let titulo = prompt("Introduce el titulo a borrar").trim;
        borrarTitulo(titulo)
}

function borrarTitulo (nombreB){
        const bibliotecaActualizada = biblioteca.filter(libro => libro.getTitulo() !== nombreB);
        biblioteca = bibliotecaActualizada;
        console.log(bibliotecaActualizada);
        console.log(biblioteca);
        imprimirLibreria(bibliotecaActualizada);
}

function calcularMediaAnios (){
        if (biblioteca.length=== 0){
            alert("No hay libros registrados")
            return;
        }
        let anyioActual =  new Date().getFullYear()
        let totalAnios = biblioteca.reduce((acumulador, libro) => acumulador += (anyioActual - libro.anio), 0);
        let mediaAnios = totalAnios / biblioteca.length;
        console.log(totalAnios);
        console.log(mediaAnios);
        parrafoMediaAnios.innerHTML = `La media de años de todos los libros de la biblioteca es: ${mediaAnios} años`;
}




