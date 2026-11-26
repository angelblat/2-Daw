1. Modelado de los Datos

   Cada producto registrado en el sistema debe contener la siguiente información:
   • Nombre del producto.
   • Categoría (a elegir entre: Electrónica, Hogar o Alimentación).
   • Precio en euros.

   Además, cada producto debe ser capaz de generar su propia ficha descriptiva mediante un método propio que
   devuelva un texto con el siguiente formato exacto:

   Televisor [Categoría: Electrónica] - Precio: 299.99 €

2. Funcionalidades de la Aplicación

   La interfaz constará de un formulario y una serie de controles para realizar las siguientes acciones:

   • Registrar producto: Permite introducir el nombre, la categoría y el precio. Al pulsar el botón, el nuevo
   producto se añade al listado, se actualiza el almacenamiento de la sesión y se limpia el formulario.
   • Descartar último producto: Elimina del listado el último producto que fue introducido.
   • Eliminar producto por nombre: Mediante un campo de búsqueda o entrada de texto, el usuario podrá indicar
   el nombre de un producto y pulsar un botón para eliminar del inventario cualquier artículo que coincida con
   ese nombre.
   • Valor total del inventario: Debe existir un apartado visible en la interfaz que calcule y muestre la suma
   acumulada del precio de todos los productos presentes en el catálogo en ese momento (con formato 0.00 €).
   • Visualización: El listado en pantalla debe mostrar cada producto utilizando el texto que genera su propio
   método de ficha descriptiva.

3. Requisito de Persistencia

   • Toda la información debe almacenarse en el almacenamiento de sesión del navegador (sessionStorage)
   bajo la clave "inventario-almacen".
   • Al recargar la página, el catálogo debe mantenerse intacto y operativo: los productos recuperados del
   almacenamiento deben seguir funcionando con todos sus métodos y propiedades sin generar errores en la
   consola.

   Nota técnica para la entrega: Recuerda que al recuperar objetos desde sessionStorage mediante
   JSON.parse(), los métodos del prototipo u objeto original se pierden. Asegúrate de reinstanciar o rehidratar
   cada producto para conservar el método de la ficha descriptiva.