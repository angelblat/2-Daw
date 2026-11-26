const varInput = document.getElementById("nombre-usuario");
const parrafo = document.getElementById("feedback-usuario");

varInput.addEventListener("keyup", keyEvent);

function keyEvent(){
    const valorInput = varInput.value.toString();
    console.log(valorInput);

    if (valorInput.length<5){
        parrafo.innerHTML = "Necesitas al menos 5 caracteres";
        parrafo.style.color = "#F4320B";
    } else {
        parrafo.innerHTML = "Valor recogido con éxito";
        parrafo.style.color = "#5FBF1F";
    }
}

varInput.addEventListener('focus', cambiarBorde1);
varInput.addEventListener('blur', cambiarBorde2);

function cambiarBorde1() {
    varInput.style.outline = "none";      // Oculta el borde por defecto del navegador que tapa tu color
    varInput.style.border = "2px solid blue";
}

function cambiarBorde2() {
    varInput.style.border = "1px solid black";
}



/*
function cambiarBorde (){
    varInput.style.borderRadius = '4px';
    varInput.style.borderColor = "blue";
}
*/