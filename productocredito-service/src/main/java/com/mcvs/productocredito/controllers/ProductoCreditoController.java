package com.mcvs.productocredito.controllers;
import com.mcvs.productocredito.entity.ProductoCredito;
import com.mcvs.productocredito.service.ProductoCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/productoscredito")
public class ProductoCreditoController 
{
    @Autowired
    private ProductoCreditoService productoCreditoService;
    @PostMapping
    public ResponseEntity<ProductoCredito> guardarProductoCredito(@RequestBody ProductoCredito productoCreditoRequest) 
    {
        ProductoCredito productoCredito = productoCreditoService.saveProductoCredito(productoCreditoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoCredito);
    }
    @GetMapping("/{productoCreditoId}")
    public ResponseEntity<ProductoCredito> obtenerProductoCredito(@PathVariable Long productoCreditoId) 
    {
        ProductoCredito productoCredito = productoCreditoService.getProductoCredito(productoCreditoId);
        if (productoCredito != null) 
        {
            return ResponseEntity.ok(productoCredito);
        } 
        else 
        {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/tipo/{tipoCredito}")
    public ResponseEntity<List<ProductoCredito>> listarProductosCreditoPorTipo(@PathVariable ProductoCredito.TipoCredito tipoCredito) 
    {
        List<ProductoCredito> productosCredito = productoCreditoService.getProductosCreditoByTipo(tipoCredito);
        return ResponseEntity.ok(productosCredito);
    }
    @GetMapping("/tasainteres/{tasaInteres}")
    public ResponseEntity<List<ProductoCredito>> listarProductosCreditoPorTasaInteres(@PathVariable BigDecimal tasaInteres) 
    {
        List<ProductoCredito> productosCredito = productoCreditoService.getProductosCreditoByTasaInteres(tasaInteres);
        return ResponseEntity.ok(productosCredito);
    }
    @GetMapping
    public ResponseEntity<List<ProductoCredito>> listarTodosLosProductosCredito() 
    {
        List<ProductoCredito> productosCredito = productoCreditoService.getAllProductosCredito();
        return ResponseEntity.ok(productosCredito);
    }
}