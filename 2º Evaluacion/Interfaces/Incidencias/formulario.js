/*
 * formulario.js Â· Registro de incidencias (UD4 Â· 2Âº DAW)
 * Valida el formulario, muestra los errores junto a cada campo,
 * simula el envÃ­o y avisa a Clarity de los eventos importantes.
 */
(() => {
  'use strict';

  const form = document.getElementById('form-incidencia');
  if (!form) {
    console.error('formulario.js: no se encuentra el formulario #form-incidencia');
    return;
  }
  form.noValidate = true; // usamos nuestros propios mensajes de error

  // ---------- 1. Mensajes de error: dicen quÃ© pasa y cÃ³mo corregirlo ----------
  const MENSAJES = {
    nombre: { valueMissing: 'Escribe tu nombre y apellidos.' },
    email: {
      valueMissing: 'Escribe tu correo electrÃ³nico.',
      typeMismatch: 'El correo no es vÃ¡lido. Ejemplo: nombre@centro.es'
    },
    ubicacion: { valueMissing: 'Elige el aula o espacio donde estÃ¡ la averÃ­a.' },
    tipo: { valueMissing: 'Indica el tipo de incidencia.' },
    prioridad: { valueMissing: 'Indica la prioridad de la incidencia.' },
    fecha: {
      valueMissing: 'Indica la fecha en que detectaste la averÃ­a.',
      rangeOverflow: 'La fecha no puede ser posterior a hoy.'
    },
    descripcion: {
      valueMissing: 'Describe quÃ© ocurre.',
      tooShort: 'Explica un poco mÃ¡s: la descripciÃ³n necesita al menos 20 caracteres.'
    }
  };

  // ---------- 2. Eventos personalizados para Clarity ----------
  const eventoClarity = (nombre) => {
    if (typeof window.clarity === 'function') window.clarity('event', nombre);
  };

  // ---------- 3. Utilidades ----------
  const BOTONES = ['submit', 'reset', 'button'];

  const controlesDe = (nombre) => {
    const c = form.elements[nombre];
    return c instanceof RadioNodeList ? Array.from(c) : [c];
  };

  const nombresCampos = () => {
    const nombres = [];
    Array.from(form.elements).forEach((el) => {
      if (el.name && !BOTONES.includes(el.type) && !nombres.includes(el.name)) {
        nombres.push(el.name);
      }
    });
    return nombres;
  };

  const anadirDescribedBy = (el, id) => {
    const ids = (el.getAttribute('aria-describedby') || '').split(' ').filter(Boolean);
    if (!ids.includes(id)) {
      ids.push(id);
      el.setAttribute('aria-describedby', ids.join(' '));
    }
  };

  // ---------- 4. La fecha no puede ser futura ----------
  const hoyISO = (() => {
    const d = new Date();
    d.setMinutes(d.getMinutes() - d.getTimezoneOffset());
    return d.toISOString().slice(0, 10);
  })();
  if (form.elements.fecha) form.elements.fecha.max = hoyISO;

  // ---------- 5. Contador de caracteres de la descripciÃ³n ----------
  const descripcion = form.elements.descripcion;
  let actualizarContador = () => {};
  if (descripcion) {
    const minimo = descripcion.minLength > 0 ? descripcion.minLength : 20;
    const contador = document.createElement('p');
    contador.id = 'descripcion-contador';
    contador.className = 'contador';
    descripcion.after(contador);
    anadirDescribedBy(descripcion, contador.id);
    actualizarContador = () => {
      const n = descripcion.value.trim().length;
      contador.textContent = n < minimo
        ? `${n} de ${minimo} caracteres mÃ­nimos`
        : `${n} caracteres`;
    };
    descripcion.addEventListener('input', actualizarContador);
    actualizarContador();
  }

  // ---------- 6. Resumen de errores (arriba) y mensaje de confirmaciÃ³n ----------
  const resumen = document.createElement('div');
  resumen.id = 'resumen-errores';
  resumen.className = 'resumen-errores';
  resumen.setAttribute('role', 'alert');
  resumen.tabIndex = -1;
  resumen.hidden = true;
  form.prepend(resumen);

  let aviso = document.getElementById('confirmacion');
  if (!aviso) {
    aviso = document.createElement('p');
    aviso.id = 'confirmacion';
    form.after(aviso);
  }
  aviso.setAttribute('role', 'status');
  aviso.tabIndex = -1;
  aviso.hidden = true;

  // ---------- 7. ValidaciÃ³n de un campo ----------
  const mensajeError = (nombre) => {
    const controles = controlesDe(nombre);
    const primero = controles[0];
    const textos = MENSAJES[nombre] || {};

    if (primero.type === 'radio') {
      const obligatorio = controles.some((c) => c.required);
      const marcado = controles.some((c) => c.checked);
      return obligatorio && !marcado ? (textos.valueMissing || 'Elige una opciÃ³n.') : '';
    }
    if (primero.type === 'checkbox') {
      return primero.required && !primero.checked
        ? (textos.valueMissing || 'Debes marcar esta casilla.')
        : '';
    }

    const valor = primero.value.trim();
    if (primero.required && valor === '') return textos.valueMissing || 'Este campo es obligatorio.';
    if (valor === '') return '';
    if (primero.minLength > 0 && valor.length < primero.minLength) {
      return textos.tooShort || `Escribe al menos ${primero.minLength} caracteres.`;
    }
    const v = primero.validity;
    if (v.typeMismatch) return textos.typeMismatch || 'El formato no es vÃ¡lido.';
    if (v.rangeOverflow) return textos.rangeOverflow || 'El valor es demasiado alto.';
    if (v.rangeUnderflow) return textos.rangeUnderflow || 'El valor es demasiado bajo.';
    if (v.patternMismatch) return textos.patternMismatch || 'El formato no es vÃ¡lido.';
    if (!v.valid) return primero.validationMessage;
    return '';
  };

  const mostrarError = (nombre, texto) => {
    const controles = controlesDe(nombre);
    const primero = controles[0];
    const idError = `${nombre}-error`;
    let error = document.getElementById(idError);

    if (!error && texto) {
      error = document.createElement('p');
      error.id = idError;
      error.className = 'error';
      const grupo = primero.type === 'radio' ? primero.closest('fieldset') : null;
      if (grupo) grupo.append(error);
      else primero.after(error);
      controles.forEach((c) => anadirDescribedBy(c, idError));
    }
    if (error) {
      error.textContent = texto;
      error.hidden = texto === '';
    }
    controles.forEach((c) => {
      if (texto) c.setAttribute('aria-invalid', 'true');
      else c.removeAttribute('aria-invalid');
    });
    return texto === '';
  };

  const validarCampo = (nombre) => mostrarError(nombre, mensajeError(nombre));

  const limpiarErrores = () => {
    nombresCampos().forEach((n) => mostrarError(n, ''));
    resumen.hidden = true;
  };

  // ---------- 8. ValidaciÃ³n mientras se rellena ----------
  // Al salir de un campo con texto, se comprueba.
  form.addEventListener('focusout', (e) => {
    const el = e.target;
    if (!el.name || BOTONES.includes(el.type) || el.type === 'radio' || el.type === 'checkbox') return;
    if (el.value.trim() !== '' || el.hasAttribute('aria-invalid')) validarCampo(el.name);
  });
  // Radios, casillas y desplegables se comprueban al cambiar.
  form.addEventListener('change', (e) => {
    const el = e.target;
    if (el.name && (el.type === 'radio' || el.type === 'checkbox' || el.tagName === 'SELECT')) {
      validarCampo(el.name);
    }
  });
  // Si un campo tenÃ­a error, el mensaje desaparece en cuanto se corrige.
  form.addEventListener('input', (e) => {
    const el = e.target;
    if (el.name && el.hasAttribute('aria-invalid')) validarCampo(el.name);
  });

  // ---------- 9. Resumen de errores con enlaces a cada campo ----------
  const mostrarResumen = (fallos) => {
    resumen.replaceChildren();
    const titulo = document.createElement('h2');
    titulo.textContent = fallos.length === 1
      ? 'Hay 1 campo por corregir'
      : `Hay ${fallos.length} campos por corregir`;
    const lista = document.createElement('ul');
    fallos.forEach((nombre) => {
      const control = controlesDe(nombre)[0];
      if (!control.id) control.id = `campo-${nombre}`;
      const enlace = document.createElement('a');
      enlace.href = `#${control.id}`;
      enlace.textContent = document.getElementById(`${nombre}-error`).textContent;
      enlace.addEventListener('click', (ev) => {
        ev.preventDefault();
        control.focus();
      });
      const li = document.createElement('li');
      li.append(enlace);
      lista.append(li);
    });
    resumen.append(titulo, lista);
    resumen.hidden = false;
    resumen.focus();
  };

  // ---------- 10. EnvÃ­o (simulado) ----------
  let reseteoInterno = false;

  form.addEventListener('submit', (e) => {
    e.preventDefault();
    aviso.hidden = true;

    const fallos = nombresCampos().filter((n) => !validarCampo(n));
    if (fallos.length > 0) {
      mostrarResumen(fallos);
      eventoClarity('error_validacion');
      return;
    }
    resumen.hidden = true;

    const anio = new Date().getFullYear();
    const numero = String(Math.floor(Math.random() * 10000)).padStart(4, '0');
    const codigo = `INC-${anio}-${numero}`;
    const ubicacion = form.elements.ubicacion;
    const lugar = ubicacion && ubicacion.options && ubicacion.selectedIndex >= 0
      ? ubicacion.options[ubicacion.selectedIndex].text
      : '';

    // AquÃ­ se enviarÃ­an los datos a un servidor. En GitHub Pages solo los mostramos en consola.
    console.table(Object.fromEntries(new FormData(form)));

    aviso.textContent = `Incidencia ${codigo} registrada correctamente${lugar ? ` (${lugar})` : ''}. Guarda este cÃ³digo para consultarla.`;
    aviso.className = 'confirmacion';
    aviso.hidden = false;
    aviso.focus();
    eventoClarity('incidencia_enviada');

    reseteoInterno = true;
    form.reset();
  });

  // ---------- 11. BotÃ³n Limpiar: pide confirmaciÃ³n si hay datos ----------
  const hayDatos = () => Array.from(form.elements).some((el) => {
    if (!el.name || BOTONES.includes(el.type)) return false;
    if (el.type === 'radio' || el.type === 'checkbox') return el.checked;
    if (el.tagName === 'SELECT') return el.selectedIndex > 0;
    return el.value.trim() !== '';
  });

  form.addEventListener('reset', (e) => {
    if (!reseteoInterno) {
      if (hayDatos() && !window.confirm('Â¿Seguro que quieres borrar todo lo que has escrito?')) {
        e.preventDefault();
        return;
      }
      aviso.hidden = true;
      eventoClarity('formulario_limpiado');
    }
    reseteoInterno = false;
    setTimeout(() => {
      limpiarErrores();
      actualizarContador();
    }, 0);
  });
})();