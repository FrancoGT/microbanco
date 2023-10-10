package com.mcvs.productocredito.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mcvs.productocredito.entity.ProductoCredito;
import com.mcvs.productocredito.exception.ProductoCreditoNotFoundException;
import com.mcvs.productocredito.repository.ProductoCreditoRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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
    @Override
    public ProductoCredito updateProductoCredito(Long productoCreditoId, ProductoCredito productoCredito) 
    {
        // Verifica si el producto de crédito con el ID dado existe en la base de datos
        Optional<ProductoCredito> existingProductoCredito = productoCreditoRepository.findById(productoCreditoId);
        if (existingProductoCredito.isPresent()) 
        {
            // Actualiza los campos del producto de crédito existente con los valores proporcionados
            ProductoCredito updatedProductoCredito = existingProductoCredito.get();
            updatedProductoCredito.setTipoCredito(productoCredito.getTipoCredito());
            updatedProductoCredito.setTasaInteres(productoCredito.getTasaInteres());
            updatedProductoCredito.setPlazo(productoCredito.getPlazo());
            updatedProductoCredito.setFechaVencimiento(productoCredito.getFechaVencimiento());

            // Guarda el producto de crédito actualizado en la base de datos
            return productoCreditoRepository.save(updatedProductoCredito);
        } 
        else 
        {
            // El producto de crédito con el ID dado no existe, puedes lanzar una excepción o manejarlo de otra manera
            throw new ProductoCreditoNotFoundException("Producto de crédito no encontrado");
        }
    }

    @Override
    public boolean deleteProductoCredito(Long productoCreditoId) 
    {
        // Verifica si el producto de crédito con el ID dado existe en la base de datos
        Optional<ProductoCredito> existingProductoCredito = productoCreditoRepository.findById(productoCreditoId);
        if (existingProductoCredito.isPresent()) 
        {
            // Elimina el producto de crédito de la base de datos
            productoCreditoRepository.deleteById(productoCreditoId);
            return true;
        } 
        else 
        {
            // El producto de crédito con el ID dado no existe, puedes devolver false o lanzar una excepción
            return false;
        }
    }
}