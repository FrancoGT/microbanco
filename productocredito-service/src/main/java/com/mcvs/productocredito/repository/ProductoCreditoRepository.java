package com.mcvs.productocredito.repository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mcvs.productocredito.entity.ProductoCredito;

@Repository
public interface ProductoCreditoRepository extends JpaRepository<ProductoCredito, Long> 
{
    // No es necesario definir los métodos CRUD básicos, JpaRepository ya los proporciona automáticamente.
    
    // Puedes agregar métodos personalizados según tus necesidades aquí si es necesario.
    
    // Por ejemplo, para buscar productos de crédito por tipo de crédito:
    List<ProductoCredito> findByTipoCredito(ProductoCredito.TipoCredito tipoCredito);
    
    // O para buscar productos de crédito por tasa de interés:
    List<ProductoCredito> findByTasaInteres(BigDecimal tasaInteres);
    
    // También puedes agregar métodos para buscar productos de crédito por clienteId, plazo, fecha de vencimiento, etc., según tus requisitos.
}