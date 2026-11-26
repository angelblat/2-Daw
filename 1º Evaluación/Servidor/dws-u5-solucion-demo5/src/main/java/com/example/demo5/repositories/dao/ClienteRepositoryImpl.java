package com.example.demo5.repositories.dao;

import com.example.demo5.repositories.entity.Cliente;
import com.example.demo5.repositories.entity.Cuenta;
import com.example.demo5.repositories.entity.Recomendacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    private static List<Cliente> datos = new ArrayList<Cliente>();

    static {
        Cliente c1 = new Cliente();
        c1.setId((long) (datos.size() + 1));
        c1.setNombre("Antonio");
        c1.setApellidos("López");
        c1.setNif("11111111A");
        c1.setEmail("antonio.lopez@prueba.com");
        c1.setClaveSeguridad("12345");
        Recomendacion r1 = new Recomendacion();
        r1.setId((long) (datos.size() + 1));
        r1.setObservaciones("No tiene ninguna");
        r1.setCliente(c1);
        c1.setRecomendacion(r1);
        datos.add(c1);

        Cliente c2 = new Cliente();
        c2.setId((long) (datos.size() + 1));
        c2.setNombre("Belen");
        c2.setApellidos("Cuenca");
        c2.setNif("22222222B");
        c2.setEmail("belen.cuenca@prueba.com");
        c2.setClaveSeguridad("67890");
        Recomendacion r2 = new Recomendacion();
        r2.setId((long) (datos.size() + 1));
        r2.setObservaciones("Muy recomendada");
        r2.setCliente(c2);
        c2.setRecomendacion(r2);
        datos.add(c2);

        Cliente c3 = new Cliente();
        c3.setId((long) (datos.size() + 1));
        c3.setNombre("Juan");
        c3.setApellidos("Pérez");
        c3.setNif("33333333C");
        c3.setEmail("juan.perez@prueba.com");
        c3.setClaveSeguridad("02468");
        Recomendacion r3 = new Recomendacion();
        r3.setId((long) (datos.size() + 1));
        r3.setObservaciones("Sin comentarios");
        r3.setCliente(c3);
        c3.setRecomendacion(r3);
        datos.add(c3);

        Cliente c4 = new Cliente();
        c4.setId((long) (datos.size() + 1));
        c4.setNombre("María");
        c4.setApellidos("Rodríguez");
        c4.setNif("44444444D");
        c4.setEmail("maria.rodriguez@prueba.com");
        c4.setClaveSeguridad("13579");
        Recomendacion r4 = new Recomendacion();
        r4.setId((long) (datos.size() + 1));
        r4.setObservaciones("Le encanta The Mandalorian");
        r4.setCliente(c4);
        c4.setRecomendacion(r4);
        datos.add(c4);

        Cliente c5 = new Cliente();
        c5.setId((long) (datos.size() + 1));
        c5.setNombre("Juan");
        c5.setApellidos("Gómez-Jurado");
        c5.setNif("55555555E");
        c5.setEmail("juan.gomez-jurado@prueba.com");
        c5.setClaveSeguridad("98765");
        Recomendacion r5 = new Recomendacion();
        r5.setId((long) (datos.size() + 1));
        r5.setObservaciones("Escritor famoso");
        r5.setCliente(c5);
        c5.setRecomendacion(r5);
        datos.add(c5);

        // Cuentas de Antonio (c1)
        Cuenta cu1 = new Cuenta();
        cu1.setId(1L);
        cu1.setBanco("2100");
        cu1.setSucursal("0418");
        cu1.setDc("45");
        cu1.setNumeroCuenta("0200051332");
        cu1.setSaldoActual(1520.75);
        cu1.setCliente(c1);
        c1.getListaCuentas().add(cu1);

        Cuenta cu2 = new Cuenta();
        cu2.setId(2L);
        cu2.setBanco("0049");
        cu2.setSucursal("1500");
        cu2.setDc("05");
        cu2.setNumeroCuenta("1234567890");
        cu2.setSaldoActual(300.00);
        cu2.setCliente(c1);
        c1.getListaCuentas().add(cu2);

        // Cuenta de Belén (c2)
        Cuenta cu3 = new Cuenta();
        cu3.setId(3L);
        cu3.setBanco("0182");
        cu3.setSucursal("2370");
        cu3.setDc("41");
        cu3.setNumeroCuenta("0201504830");
        cu3.setSaldoActual(12850.40);
        cu3.setCliente(c2);
        c2.getListaCuentas().add(cu3);

        // Cuenta de María (c4)
        Cuenta cu4 = new Cuenta();
        cu4.setId(4L);
        cu4.setBanco("2085");
        cu4.setSucursal("0103");
        cu4.setDc("92");
        cu4.setNumeroCuenta("0300731702");
        cu4.setSaldoActual(87.10);
        cu4.setCliente(c4);
        c4.getListaCuentas().add(cu4);
    }

    @Override
    public List<Cliente> findAll() {
        return datos;
    }

    @Override
    public Cliente findById(Cliente cliente) {
        int posicion = datos.indexOf(cliente);
        if (posicion != -1) {
            return datos.get(posicion);
        }
        return null;
    }

    @Override
    public void save(Cliente cliente) {
        if (cliente.getId() != null) {
            // ACTUALIZAR: Rescatamos la lista de cuentas del cliente antiguo
            int posicion = datos.indexOf(cliente);
            Cliente clienteAntiguo = datos.get(posicion);

            cliente.setListaCuentas(clienteAntiguo.getListaCuentas());
            for (Cuenta cuenta : cliente.getListaCuentas()) {
                cuenta.setCliente(cliente);
            }

            // Aseguramos también la referencia bidireccional de la recomendación
            if (cliente.getRecomendacion() != null) {
                cliente.getRecomendacion().setId(cliente.getId());
                cliente.getRecomendacion().setCliente(cliente);
            }

            datos.set(posicion, cliente);
        } else {
            // INSERTAR
            long id = 1L;
            if (!datos.isEmpty()) {
                id = datos.getLast().getId() + 1;
            }
            cliente.setId(id);

            if (cliente.getRecomendacion() != null) {
                cliente.getRecomendacion().setId(id);
                cliente.getRecomendacion().setCliente(cliente);
            }

            datos.add(cliente);
        }
    }

    @Override
    public void delete(Cliente cliente) {
        datos.remove(cliente); // Sus cuentas se borran en cascada al estar dentro de su lista
    }
    }