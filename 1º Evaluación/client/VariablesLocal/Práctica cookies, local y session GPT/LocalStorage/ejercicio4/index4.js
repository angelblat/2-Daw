const campoTexto = document.getElementById("campoTexto");
const btn1 = document.getElementById("btn-anadir");
const btn2 = document.getElementById("btn-eliminar");
const lista = document.getElementById("listaTareas");

let listaTareas = JSON.parse(localStorage.getItem("listaTareas")) || [];
listaTareas.length > 0 ? mostrarLista() : console.log("la lista esta vacia");

btn1.addEventListener("click", anadirTarea);
btn2.addEventListener("click", eliminarTarea);

function anadirTarea(){
    if (campoTexto.value.trim() === ""){
        Swal.fire({
            title: 'Advertencia!',
            text: 'No se puede añadir nada por que no has introducido ninguna tarea',
            icon: 'warning',
            confirmButtonText: 'Entendido'
        })
    } else {
        let valor = campoTexto.value;
        listaTareas.push(valor);
        localStorage.setItem("listaTareas", JSON.stringify(listaTareas))
        mostrarLista();
    }
}

function mostrarLista(){
    lista.innerHTML = "";
    listaTareas.forEach(tarea => {lista.insertAdjacentHTML("beforeend", `<li>${tarea}</li>`)})
}

function eliminarTarea(){
    if (campoTexto.value.trim() === ""){
        alert("No se puede eliminar nada por que no has escrito ninguna tarea")
    } else {
        let valor = campoTexto.value;
        const existe = listaTareas.includes(valor);
        existe ? listaTareas = listaTareas.filter(tarea => tarea !== valor)
            : Swal.fire({
                title: 'Error!',
                text: 'El valor introducido no coincide con ninguna tarea pendiente',
                icon: 'error',
                confirmButtonText: 'Entendido'
            })
        listaTareas.length > 0 ? localStorage.setItem("listaTareas", JSON.stringify(listaTareas)) : localStorage.removeItem("listaTareas")
        mostrarLista();
    }
}