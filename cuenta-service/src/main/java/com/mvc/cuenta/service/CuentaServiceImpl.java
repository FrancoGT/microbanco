package com.mvc.cuenta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.cuenta.entity.Cuenta;
import com.mvc.cuenta.repository.CuentaRepository;

@Service
public class CuentaServiceImpl implements CuentaService {

    private final CuentaRepository cuentaRepository;

    @Autowired
    public CuentaServiceImpl(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public Cuenta saveCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public List<Cuenta> getAllCuentas() {
        return cuentaRepository.findAll();
    }

    @Override
    public Cuenta getCuenta(Long cuentaId) {
        return cuentaRepository.findById(cuentaId).orElse(null);
    }

    @Override
    public List<Cuenta> getCuentasByTipo(Cuenta.TipoCuenta tipoCuenta) {
        return cuentaRepository.findByTipoCuenta(tipoCuenta);
    }

    @Override
    public List<Cuenta> getCuentasByClienteId(Long clienteId) {
        return cuentaRepository.findByClienteId(clienteId);
    }

    // Agrega otros métodos personalizados según tus necesidades.
}