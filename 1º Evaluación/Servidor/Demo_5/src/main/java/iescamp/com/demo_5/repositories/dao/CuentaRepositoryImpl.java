package iescamp.com.demo_5.repositories.dao;

import iescamp.com.demo_5.repositories.entities.Cliente;
import iescamp.com.demo_5.repositories.entities.Cuenta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CuentaRepositoryImpl implements CuentaRepository {

    private static List<Cuenta> datos = new ArrayList<Cuenta>();

    static {
        Cuenta cu1 = new Cuenta();
        cu1.setId(Long.valueOf(datos.size() + 1));
        cu1.setBanco("1234");
        cu1.setSucursal("5678");
        cu1.setDc("90");
        cu1.setNumeroCuenta("1234567890");
        cu1.setSaldoCuenta(1500.50);

        Cliente cl1 = new Cliente();
        cl1.setId(1L);
        cu1.setCliente(cl1);
        datos.add(cu1);

        Cuenta cu2 = new Cuenta();
        cu2.setId(Long.valueOf(datos.size() + 1));
        cu2.setBanco("9876");
        cu2.setSucursal("5432");
        cu2.setDc("10");
        cu2.setNumeroCuenta("0987654321");
        cu2.setSaldoCuenta(3200.75);

        Cliente cl2 = new Cliente();
        cl2.setId(2L);
        cu2.setCliente(cl2);
        datos.add(cu2);
    }


    @Override
    public List<Cuenta> findAll() {
        return datos;
    }

    @Override
    public Cuenta findById(Cuenta cuenta) {
        int posicion = datos.indexOf(cuenta);
        return datos.get(posicion);
    }

    @Override
    public void save(Cuenta cuenta) {
        if (cuenta.getId() != null){
            int posicion = datos.indexOf(cuenta);
            datos.set(posicion, cuenta);
        } else {
            Long id = datos.get(datos.size() - 1).getId() + 1;
            cuenta.setId(id);
            cuenta.setId(id);
            datos.add(cuenta);
        }
    }

    @Override
    public void delete(Cuenta cuenta) {
        int posicion = datos.indexOf(cuenta);
        datos.remove(posicion);
    }
}
