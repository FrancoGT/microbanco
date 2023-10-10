package com.mcvs.productocredito.service;
import com.mcvs.productocredito.entity.ProductoCredito;
import java.math.BigDecimal;
import java.util.List;

public interface ProductoCreditoService 
{
    ProductoCredito saveProductoCredito(ProductoCredito productoCredito);
    List<ProductoCredito> getAllProductosCredito();
    ProductoCredito getProductoCredito(Long productoCreditoId);
    List<ProductoCredito> getProductosCreditoByTipo(ProductoCredito.TipoCredito tipoCredito);
    List<ProductoCredito> getProductosCreditoByTasaInteres(BigDecimal tasaInteres);
    ProductoCredito updateProductoCredito(Long productoCreditoId, ProductoCredito productoCredito);
    boolean deleteProductoCredito(Long productoCreditoId);
}