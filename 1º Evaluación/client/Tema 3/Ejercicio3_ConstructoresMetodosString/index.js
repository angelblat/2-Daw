const btnAgregar = document.getElementById("btn-Agregar");
const lista = document.getElementById("lista");
btnAgregar.addEventListener("click", agregarLibro);

let biblioteca = [];

    /*let genero = document.getElementById("genero");
    let autor = document.getElementById("autor");
    let anio = document.getElementById("anio");
    let titulo = document.getElementById("titulo");

    libro.titulo = titulo.value;
    libro.autor = autor.value;
    libro.genero = genero.value;
    libro.anio = anio.value;
    */

    function Libro(titulo, autor, genero, anio) {
        // Propiedades del objeto
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anio = anio;

        // --- GETTERS (Para leer los datos) ---
        this.getTitulo = function() {
            return this.titulo;
        };
        this.getAutor = function() {
            return this.autor;
        };
        this.getGenero = function() {
            return this.genero;
        };
        this.getAnio = function() {
            return this.anio;
        };

        // --- SETTERS (Para modificar los datos) ---
        this.setTitulo = function(nuevoTitulo) {
            this.titulo = nuevoTitulo;
        };
        this.setAutor = function(nuevoAutor) {
            this.autor = nuevoAutor;
        };
        this.setGenero = function(nuevoGenero) {
            this.genero = nuevoGenero;
        };
        this.setAnio = function(nuevoAnio) {
            this.anio = nuevoAnio;
        };

        this.mostrarInfo = function() {
            return `Título: ${this.titulo}, Autor: ${this.autor}, Año: ${this.anio}, Género: ${this.genero}`;
        };
    }

function agregarLibro() {
    // Descomentamos tus variables para capturar los datos del HTML (.value)
    let tituloHTML = document.getElementById("titulo").value;
    let autorHTML = document.getElementById("autor").value;
    let generoHTML = document.getElementById("genero").value;
    let anioHTML = document.getElementById("anio").value;
    let libroNuevo = new Libro(tituloHTML, autorHTML, generoHTML, anioHTML);

    // Guardamos el objeto recién creado dentro de nuestro array
    biblioteca.push(libroNuevo);

    console.log("¡Libro guardado con éxito en la biblioteca!");
    console.log(libroNuevo.mostrarInfo()); // Podemos probar que funciona
    mostrarLibros();
}

function mostrarLibros() {
    lista.innerHTML = biblioteca.map(libro => {
        return `<li>${libro.mostrarInfo()}</li>`;
    }).join("");
}

