const boton = document.getElementById("btn-calcular");
const parrafo = document.getElementById("resultado-calculo");

boton.addEventListener("click", calcular);

function calcular(){
    const num1 = Number(document.getElementById("numero1").value);
    const num2 = Number(document.getElementById("numero2").value);

    parrafo.innerHTML = num1 + num2;
}