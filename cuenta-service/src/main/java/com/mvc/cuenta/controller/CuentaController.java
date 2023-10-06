package com.mvc.cuenta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.cuenta.entity.Cuenta;
import com.mvc.cuenta.service.CuentaService;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    private final CuentaService cuentaService;

    @Autowired
    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @PostMapping
    public Cuenta createCuenta(@RequestBody Cuenta cuenta) {
        return cuentaService.saveCuenta(cuenta);
    }

    @GetMapping
    public List<Cuenta> getAllCuentas() {
        return cuentaService.getAllCuentas();
    }

    @GetMapping("/{cuentaId}")
    public Cuenta getCuenta(@PathVariable Long cuentaId) {
        return cuentaService.getCuenta(cuentaId);
    }

    @GetMapping("/byTipo/{tipoCuenta}")
    public List<Cuenta> getCuentasByTipo(@PathVariable Cuenta.TipoCuenta tipoCuenta) {
        return cuentaService.getCuentasByTipo(tipoCuenta);
    }

    @GetMapping("/byCliente/{clienteId}")
    public List<Cuenta> getCuentasByClienteId(@PathVariable Long clienteId) {
        return cuentaService.getCuentasByClienteId(clienteId);
    }

    // Puedes agregar más métodos para otras operaciones según tus necesidades.
}