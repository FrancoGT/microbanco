package com.mvc.tarjetacredito.entity.service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.tarjetacredito.entity.TarjetaCredito;
import com.mvc.tarjetacredito.repository.TarjetaCreditoRepository;


@Service
public class TarjetaCreditoServiceImpl implements TarjetaCreditoService 
{

    private final TarjetaCreditoRepository tarjetaCreditoRepository;

    @Autowired
    public TarjetaCreditoServiceImpl(TarjetaCreditoRepository tarjetaCreditoRepository) 
    {
        this.tarjetaCreditoRepository = tarjetaCreditoRepository;
    }

    @Override
    public TarjetaCredito saveTarjetaCredito(TarjetaCredito tarjetaCredito) 
    {
        return tarjetaCreditoRepository.save(tarjetaCredito);
    }

    @Override
    public List<TarjetaCredito> getAllTarjetasCredito() 
    {
        return tarjetaCreditoRepository.findAll();
    }

    @Override
    public TarjetaCredito getTarjetaCredito(Long tarjetaCreditoId) {
        return tarjetaCreditoRepository.findById(tarjetaCreditoId).orElse(null);
    }

    @Override
    public List<TarjetaCredito> getTarjetasCreditoByTipo(TarjetaCredito.TipoTarjeta tipoTarjeta) 
    {
        return tarjetaCreditoRepository.findByTipoTarjeta(tipoTarjeta);
    }

    @Override
    public List<TarjetaCredito> getTarjetasCreditoByTasaInteres(BigDecimal tasaInteres) 
    {
        return null;
    }

    // Implementa otros métodos personalizados según tus necesidades.
}