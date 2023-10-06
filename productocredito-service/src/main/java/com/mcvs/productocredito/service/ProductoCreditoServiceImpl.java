package com.mcvs.productocredito.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mcvs.productocredito.entity.ProductoCredito;
import com.mcvs.productocredito.repository.ProductoCreditoRepository;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductoCreditoServiceImpl implements ProductoCreditoService 
{
    @Autowired
    private ProductoCreditoRepository productoCreditoRepository;
    @Override
    public ProductoCredito saveProductoCredito(ProductoCredito productoCredito) 
    {
        return productoCreditoRepository.save(productoCredito);
    }
    @Override
    public List<ProductoCredito> getAllProductosCredito() 
    {
        return productoCreditoRepository.findAll();
    }
    @Override
    public ProductoCredito getProductoCredito(Long productoCreditoId) 
    {
        return productoCreditoRepository.findById(productoCreditoId).orElse(null);
    }
    @Override
    public List<ProductoCredito> getProductosCreditoByTipo(ProductoCredito.TipoCredito tipoCredito) 
    {
        return productoCreditoRepository.findByTipoCredito(tipoCredito);
    }
    @Override
    public List<ProductoCredito> getProductosCreditoByTasaInteres(BigDecimal tasaInteres) 
    {
        return productoCreditoRepository.findByTasaInteres(tasaInteres);
    }
}