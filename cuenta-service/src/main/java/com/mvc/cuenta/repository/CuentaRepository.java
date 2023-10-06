package com.mvc.cuenta.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvc.cuenta.entity.Cuenta;


@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> 
{
    // No es necesario definir los métodos CRUD básicos, JpaRepository ya los proporciona automáticamente.
    
    // Puedes agregar métodos personalizados según tus necesidades aquí si es necesario.
    
    // Por ejemplo, para buscar cuentas por tipo de cuenta:
    List<Cuenta> findByTipoCuenta(Cuenta.TipoCuenta tipoCuenta);
    
    // O para buscar cuentas por clienteId:
    List<Cuenta> findByClienteId(Long clienteId);
    
    // También puedes agregar métodos para buscar cuentas por otros campos, como comision_mantenimiento, fecha_apertura, etc., según tus requisitos.
}