package com.mvc.cuenta.service;
import java.util.List;
import com.mvc.cuenta.entity.Cuenta;

public interface CuentaService 
{
    Cuenta saveCuenta(Cuenta cuenta);
    List<Cuenta> getAllCuentas();
    Cuenta getCuenta(Long cuentaId);
    List<Cuenta> getCuentasByTipo(Cuenta.TipoCuenta tipoCuenta);
    List<Cuenta> getCuentasByClienteId(Long clienteId);
    Cuenta updateCuenta(Long cuentaId, Cuenta nuevaCuenta);
    boolean deleteCuenta(Long cuentaId);
}