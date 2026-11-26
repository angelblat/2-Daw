// FUNCIÓN MAP


const celsius = [0, 10, 20, 30, 40];

// Tu código aquí:
const fahrenheit = celsius.map(x => (x * 9 / 5) + 32);

console.log(fahrenheit); 
// Resultado esperado: [32, 50, 68, 86, 104]

// Fahrenheit = (Celsius * 9/5) + 32


const carrito = [
  { nombre: "Camiseta", precio: 20, cantidad: 2 },
  { nombre: "Pantalón", precio: 40, cantidad: 1 },
  { nombre: "Zapatillas", precio: 60, cantidad: 3 }
];

// Tu código aquí:
const carritoConTotales = carrito.map(compra => {
  return {
    nuevaNombre: compra.nombre,
    nuevoPrecio: compra.precio,
    nuevaCantidad: compra.cantidad,
    precioTotal: compra.precio * compra.cantidad
  };
})

console.log(carritoConTotales);
/* Resultado esperado:
[
  { nombre: "Camiseta", precio: 20, cantidad: 2, totalProducto: 40 },
  { nombre: "Pantalón", precio: 40, cantidad: 1, totalProducto: 40 },
  { nombre: "Zapatillas", precio: 60, cantidad: 3, totalProducto: 180 }
]
*/

const nuevosUsuarios = ["Lucía", "Roberto", "Elena", "Sofía"];

// Tu código aquí:
const historialMensajes = nuevosUsuarios.map((elemento, indice) =>{
  return {
    mensaje: `${elemento} se ha conectado. Tiene ${indice} personas por delante.`,
    esElPrimero: indice === 0
  };
});

console.log(historialMensajes);
/* Resultado esperado:
[
  { mensaje: "Lucía se ha conectado. Tiene 0 personas por delante.", esElPrimero: true },
  { mensaje: "Roberto se ha conectado. Tiene 1 personas por delante.", esElPrimero: false },
  { mensaje: "Elena se ha conectado. Tiene 2 personas por delante.", esElPrimero: false },
  { mensaje: "Sofía se ha conectado. Tiene 3 personas por delante.", esElPrimero: false }
]
*/


// FUNCIÓN FILTER


const edades = [
  { nombre: "Ana", edad: 20},
  { nombre: "Pedro", edad: 15},
  { nombre: "Mario", edad: 27}
];

// Tu código aquí:
const mayoresDeEdad = edades.filter(persona => persona.edad >= 18);

console.log(mayoresDeEdad);
// Resultado esperado: [22, 18, 35, 40]


const inventario = [
  { nombre: "Teclado Mecánico", precio: 85, stock: 12 },
  { nombre: "Ratón Gaming", precio: 45, stock: 0 },
  { nombre: "Monitor 4K", precio: 350, stock: 5 },
  { nombre: "Alfombrilla XL", precio: 20, stock: 8 },
  { nombre: "Auriculares", precio: 120, stock: 3 }
];

// Tu código aquí
const productosFiltrados = inventario.filter(producto => producto.precio <= 100 && producto.stock > 0).map(producto => producto.nombre);

console.log(productosFiltrados);
/* Resultado esperado:
[
  { nombre: "Teclado Mecánico", precio: 85, stock: 12 },
  { nombre: "Alfombrilla XL", precio: 20, stock: 8 }
]
*/


const listaConDuplicados = ["manzana", "plátano", "manzana", "pera", "plátano", "naranja"];

// Tu código aquí:
const listaLimpia = listaConDuplicados.filter((elemento, indice, array) => {
  return array.indexOf(elemento) === indice;
});

console.log(listaLimpia);
// Resultado esperado: ["manzana", "plátano", "pera", "naranja"]



// Método REDUCE


const caloriasComidas = [14, 155, 199];

// Tu código aquí:
const totalCalorias =  caloriasComidas.reduce((total, comida) => total + comida, 0); 

console.log(totalCalorias);
// Resultado esperado: 2230


const almacen = [
  { producto: "Ratón", stock: 15 },
  { producto: "Teclado", stock: 8 },
  { producto: "Monitor", stock: 4 },
  { producto: "Auriculares", stock: 12 }
];


// Tu código aquí:
const totalStock = almacen.reduce((total, producto) => total + producto.stock,0);

console.log(totalStock);
// Resultado esperado: 39


const filtrosSeleccionados = [
  { clave: "categoria", valor: "camisetas" },
  { clave: "talla", valor: "L" },
  { clave: "color", valor: "azul" }
];

// Tu código aquí:
const urlFiltros = filtrosSeleccionados.reduce((acumuladorString, filtro) => {
  return acumuladorString + `&${filtro.clave}=${filtro.valor}`;
}, ""); // 👈 ¡Empezamos con un texto vacío!

console.log(urlFiltros);
// Resultado esperado: "&categoria=camisetas&talla=L&color=azul"

