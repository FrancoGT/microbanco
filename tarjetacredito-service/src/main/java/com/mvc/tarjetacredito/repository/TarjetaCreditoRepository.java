package com.mvc.tarjetacredito.repository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mvc.tarjetacredito.entity.TarjetaCredito;

@Repository
public interface TarjetaCreditoRepository extends JpaRepository<TarjetaCredito, Long> 
{
    // Puedes agregar métodos personalizados según tus necesidades aquí si es necesario.

    // Por ejemplo, para buscar tarjetas de crédito por tipo de tarjeta:
    List<TarjetaCredito> findByTipoTarjeta(TarjetaCredito.TipoTarjeta tipoTarjeta);

    // O para buscar tarjetas de crédito por saldo actual:
    List<TarjetaCredito> findBySaldoActual(BigDecimal saldoActual);

    // También puedes agregar métodos para buscar tarjetas de crédito por clienteId, fecha de vencimiento, número de cuotas, etc.,
    // según tus requisitos.
}