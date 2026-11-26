const nombres = ["alejandro     ", "  roberto", " manuela "];

const nombresModificados = nombres.map(nombre => {
    return nombre.toUpperCase().trim();
})

console.log(nombres);
console.log(nombresModificados);