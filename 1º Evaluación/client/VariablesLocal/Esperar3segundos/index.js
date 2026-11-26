const parrafo = document.getElementById("parrafo");

setTimeout(diaSemana, 3000);

    function diaSemana(){
        const tiempo = new Date();
        const dia = tiempo.getDay();
        const dias = ['domingo', 'lunes', 'martes', 'miércoles', 'jueves', 'viernes', 'sábado'];

        parrafo.innerHTML= dias[dia];
    }