package iescamp.com.demo_5.repositories.services;

import iescamp.com.demo_5.models.dto.CuentaDTO;
import iescamp.com.demo_5.repositories.dao.CuentaRepository;
import iescamp.com.demo_5.repositories.entities.Cuenta;
import iescamp.com.demo_5.repositories.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public List<CuentaDTO> findAll() {
        List<Cuenta> cuentas = cuentaRepository.findAll();
        List<CuentaDTO> cuentasDTO = new ArrayList<>();

        for (Cuenta cuenta : cuentas) {
            cuentasDTO.add(CuentaDTO.convertToDTO(cuenta));
        }
        return cuentasDTO;
    }

    @Override
    public CuentaDTO findById(CuentaDTO cuentaDTO) {
        Cuenta cuenta = CuentaDTO.convertToEntity(cuentaDTO);
        Cuenta cuentaEncontrada = cuentaRepository.findById(cuenta);

        if (cuentaEncontrada != null) {
            return CuentaDTO.convertToDTO(cuentaEncontrada);
        }
        return null;
    }

    @Override
    public void save(CuentaDTO cuentaDTO) {
        Cuenta cuenta = CuentaDTO.convertToEntity(cuentaDTO);
        cuentaRepository.save(cuenta);
    }

    @Override
    public void delete(CuentaDTO cuentaDTO) {
        Cuenta cuenta = CuentaDTO.convertToEntity(cuentaDTO);
        cuentaRepository.delete(cuenta);
    }
}
