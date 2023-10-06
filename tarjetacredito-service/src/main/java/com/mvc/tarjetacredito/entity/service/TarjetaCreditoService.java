package com.mvc.tarjetacredito.entity.service;
import java.math.BigDecimal;
import java.util.List;
import com.mvc.tarjetacredito.entity.TarjetaCredito;

public interface TarjetaCreditoService 
{
    TarjetaCredito saveTarjetaCredito(TarjetaCredito tarjetaCredito);
    List<TarjetaCredito> getAllTarjetasCredito();
    TarjetaCredito getTarjetaCredito(Long tarjetaCreditoId);
    List<TarjetaCredito> getTarjetasCreditoByTipo(TarjetaCredito.TipoTarjeta tipoTarjeta);
    List<TarjetaCredito> getTarjetasCreditoByTasaInteres(BigDecimal tasaInteres);
    // Agrega otros métodos personalizados según tus necesidades.
}