document.addEventListener("DOMContentLoaded", function(){

console.log("El DOM esta listo para usarse.")

});

const nueva_tarea = () => {

const texto = document.getElementById("tarea").value.trim();

if (texto === "") {
    console.log("Debes escribir algo")
} else {
    const li = document.createElement("li");
    li.textContent = texto;
    document.getElementById("lista_ordenada").appendChild(li);
}

};