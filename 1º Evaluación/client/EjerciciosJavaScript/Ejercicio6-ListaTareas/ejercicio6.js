let listaTareas = document.getElementById("lista-tareas");
const botonAñadir = document.getElementById("btn-anadir");
const nuevaTarea = document.getElementById("nueva-tarea");
const nuevaPrioridad = document.getElementById("nueva-prioridad");
const botonEliminar = document.getElementById("btn-eliminar-ultima");
const botonOrdenar = document.getElementById("btn-ordenar");

const clave = 'misTareas';
let tareasIniciales = obtenerListaTareas();

function obtenerListaTareas() {

    const tareasString = localStorage.getItem(clave);

    if (tareasString) {
        const tareasParseadas = JSON.parse(tareasString);

        if (tareasParseadas.length > 0) {
            return tareasParseadas;
        }
    }

    const tareasPorDefecto = [
        { nombre: 'estudiar javascript', prioridad: 'alta' },
        { nombre: 'hacer la lista de la compra', prioridad: 'baja' }
    ];

    localStorage.setItem(clave, JSON.stringify(tareasPorDefecto));

    return tareasPorDefecto;
}

renderizarTareas();

function guardarTareas(tareas) {
    localStorage.setItem(clave, JSON.stringify(tareas));
}

function renderizarTareas() {
    listaTareas.innerHTML = "";
    for (let x = 0; x < tareasIniciales.length; x++){
        listaTareas.innerHTML += `<li>Tarea: ${tareasIniciales[x].nombre}<br>Prioridad: ${tareasIniciales[x].prioridad}</li>`;
    }
}

botonAñadir.addEventListener("click", anyadirTarea);

function anyadirTarea () {
    const tarea = nuevaTarea.value.trim();
    const prioridad = nuevaPrioridad.value.trim();
    if (!tarea || !prioridad){
        alert("Debes introducir tanto el nombre de la tarea como su prioridad para añadirla")
    } else {

        // se guarda
        // se modifica
        // se muestra

        tareasIniciales.push({
            nombre: tarea,
            prioridad: prioridad
        });
        console.log(tareasIniciales);
        guardarTareas(tareasIniciales);
        renderizarTareas();
        nuevaTarea.value = "";
        nuevaPrioridad.value = "";
    }
}

botonEliminar.addEventListener("click", eliminar);

function eliminar() {

    // se elimina
    // se guarda
    // se muestra

    tareasIniciales.pop();
    guardarTareas(tareasIniciales);
    renderizarTareas();
}

botonOrdenar.addEventListener("click", ordenar);

function ordenar() {
    tareasIniciales.sort();
    guardarTareas(tareasIniciales);
    renderizarTareas();
}

/*
EJERCICIO CORREGIO

function obtenerListaTareas2() {
    const listaTareasString = localStorage.getItem(clave);
    if (listaTareasString){
        const listaTareasPlana = JSON.parse(clave);
        const listaTareasObjetos = listaTareasPlana.map(tareaPlana => new Tarea(tareaPlana.nombre, tareaPlana.prioridad));
        return listaTareasObjetos;
    }
    return [];
}

function renderizarTareas2 () {
    nuevaTarea.value = "";
    nuevaPrioridad.value = "";
    listaTareas = obtenerListaTareas();

    listaTareas.forEach(function (tarea){
        const li = document.createElement('li');
        li.textContent = tarea.mostrarTarea();
        lista.appendChild(li);
    })
}


function Tarea (nombre, prioridad){
    this.nombre = nombre;
    this.prioridad = prioridad;
    this.mostrarTarea = function(){
        return "nombre " + this.nombre + " prioridad " + this.prioridad;
    }
}

function anyadirTarea2() {
    const nombre = nuevaTarea.value.trim();
    const prioridad = nuevaPrioridad.value.trim();

    if (tarea){
        listaTareas = obtenerListaTareas();
        const tareaNueva = new Tarea(nombre, prioridad);
        listaTareas.push(tareaNueva);

        guardarTareas(listaTareas);

        renderizarTareas2();
    }
}

function guardarTareas2(tareas) {
    localStorage.setItem(clave, JSON.stringify(tareas));
}

 */
