package com.mvc.cuenta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.cuenta.entity.Cuenta;
import com.mvc.cuenta.repository.CuentaRepository;

@Service
public class CuentaServiceImpl implements CuentaService 
{

    private final CuentaRepository cuentaRepository;

    @Autowired
    public CuentaServiceImpl(CuentaRepository cuentaRepository) 
    {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public Cuenta saveCuenta(Cuenta cuenta) 
    {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public List<Cuenta> getAllCuentas() 
    {
        return cuentaRepository.findAll();
    }

    @Override
    public Cuenta getCuenta(Long cuentaId) 
    {
        return cuentaRepository.findById(cuentaId).orElse(null);
    }

    @Override
    public List<Cuenta> getCuentasByTipo(Cuenta.TipoCuenta tipoCuenta) 
    {
        return cuentaRepository.findByTipoCuenta(tipoCuenta);
    }

    @Override
    public List<Cuenta> getCuentasByClienteId(Long clienteId) 
    {
        return cuentaRepository.findByClienteId(clienteId);
    }

    @Override
    public Cuenta updateCuenta(Long cuentaId, Cuenta nuevaCuenta) 
    {
        // Verifica si la cuenta con el ID proporcionado existe en la base de datos
        Optional<Cuenta> cuentaExistente = cuentaRepository.findById(cuentaId);
        
        if (cuentaExistente.isPresent()) 
        {
            // Actualiza los campos de la cuenta existente con los valores de la nuevaCuenta
            Cuenta cuentaActualizada = cuentaExistente.get();
            cuentaActualizada.setTipoCuenta(nuevaCuenta.getTipoCuenta());
            cuentaActualizada.setComisionMantenimiento(nuevaCuenta.getComisionMantenimiento());
            cuentaActualizada.setLimiteMovimientosMensuales(nuevaCuenta.getLimiteMovimientosMensuales());
            // Actualiza otros campos si es necesario

            // Guarda la cuenta actualizada en la base de datos
            return cuentaRepository.save(cuentaActualizada);
        } 
        else 
        {
            // La cuenta con el ID proporcionado no existe
            return null;
        }
    }

    @Override
    public boolean deleteCuenta(Long cuentaId) 
    {
    	try 
    	{
            // Intenta eliminar la cuenta por su ID
            cuentaRepository.deleteById(cuentaId);
            return true; // Si la eliminación es exitosa, retorna true
        } 
    	catch (Exception e) 
    	{
            // Si se produce una excepción, por ejemplo, si la cuenta no existe, retorna false
            return false;
        }
    }
    
	
}