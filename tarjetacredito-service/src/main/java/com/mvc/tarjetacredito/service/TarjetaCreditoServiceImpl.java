package com.mvc.tarjetacredito.service;

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

    @Override
    public TarjetaCredito updateTarjetaCredito(Long tarjetaCreditoId, TarjetaCredito tarjetaCredito) 
    {
        // Comprueba si la tarjeta con el ID especificado existe en la base de datos
        if (tarjetaCreditoRepository.existsById(tarjetaCreditoId)) 
        {
            // Establece el ID en la tarjetaCredito que se va a actualizar
            tarjetaCredito.setTarjetaId(tarjetaCreditoId);
            // Utiliza el método save del repositorio para actualizar la tarjeta
            return tarjetaCreditoRepository.save(tarjetaCredito);
        } 
        else 
        {
            // Si la tarjeta no existe, puedes manejar este caso de acuerdo a tus necesidades,
            // como lanzar una excepción o retornar null.
            return null;
        }
    }

    @Override
    public boolean deleteTarjetaCredito(Long tarjetaCreditoId) 
    {
        // Comprueba si la tarjeta con el ID especificado existe en la base de datos
        if (tarjetaCreditoRepository.existsById(tarjetaCreditoId)) 
        {
            try 
            {
                // Utiliza el método deleteById del repositorio para eliminar la tarjeta por ID
                tarjetaCreditoRepository.deleteById(tarjetaCreditoId);
                return true; // Si la eliminación es exitosa
            } 
            catch (Exception e) 
            {
                // Maneja cualquier excepción que pueda ocurrir durante la eliminación
                return false;
            }
        } 
        else 
        {
            // Si la tarjeta no existe, puedes manejar este caso de acuerdo a tus necesidades,
            // como lanzar una excepción o retornar false.
            return false;
        }
    }
}