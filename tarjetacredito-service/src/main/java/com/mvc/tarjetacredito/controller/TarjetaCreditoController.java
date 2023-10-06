package com.mvc.tarjetacredito.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mvc.tarjetacredito.entity.TarjetaCredito;
import com.mvc.tarjetacredito.entity.service.TarjetaCreditoService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/tarjetascredito")
public class TarjetaCreditoController {

    @Autowired
    private TarjetaCreditoService tarjetaCreditoService;

    @PostMapping
    public ResponseEntity<TarjetaCredito> guardarTarjetaCredito(@RequestBody TarjetaCredito tarjetaCreditoRequest) {
        TarjetaCredito tarjetaCredito = tarjetaCreditoService.saveTarjetaCredito(tarjetaCreditoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarjetaCredito);
    }

    @GetMapping("/{tarjetaCreditoId}")
    public ResponseEntity<TarjetaCredito> obtenerTarjetaCredito(@PathVariable Long tarjetaCreditoId) {
        TarjetaCredito tarjetaCredito = tarjetaCreditoService.getTarjetaCredito(tarjetaCreditoId);
        if (tarjetaCredito != null) {
            return ResponseEntity.ok(tarjetaCredito);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/tipo/{tipoTarjeta}")
    public ResponseEntity<List<TarjetaCredito>> listarTarjetasCreditoPorTipo(@PathVariable TarjetaCredito.TipoTarjeta tipoTarjeta) {
        List<TarjetaCredito> tarjetasCredito = tarjetaCreditoService.getTarjetasCreditoByTipo(tipoTarjeta);
        return ResponseEntity.ok(tarjetasCredito);
    }

    @GetMapping("/tasainteres/{tasaInteres}")
    public ResponseEntity<List<TarjetaCredito>> listarTarjetasCreditoPorTasaInteres(@PathVariable BigDecimal tasaInteres) {
        List<TarjetaCredito> tarjetasCredito = tarjetaCreditoService.getTarjetasCreditoByTasaInteres(tasaInteres);
        return ResponseEntity.ok(tarjetasCredito);
    }

    @GetMapping
    public ResponseEntity<List<TarjetaCredito>> listarTodasLasTarjetasCredito() {
        List<TarjetaCredito> tarjetasCredito = tarjetaCreditoService.getAllTarjetasCredito();
        return ResponseEntity.ok(tarjetasCredito);
    }
}