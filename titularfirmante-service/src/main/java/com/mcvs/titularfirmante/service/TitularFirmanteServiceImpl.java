package com.mcvs.titularfirmante.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mcvs.titularfirmante.entity.TitularFirmante;
import com.mcvs.titularfirmante.repository.TitularFirmanteRepository;
import java.util.List;
import java.util.Optional;

@Service
public class TitularFirmanteServiceImpl implements TitularFirmanteService 
{
    @Autowired
    private TitularFirmanteRepository titularFirmanteRepository;
    @Override
    public TitularFirmante saveTitularFirmante(TitularFirmante titularFirmante) 
    {
        return titularFirmanteRepository.save(titularFirmante);
    }

    @Override
    public List<TitularFirmante> getAllTitularesFirmantes() 
    {
        return titularFirmanteRepository.findAll();
    }

    @Override
    public TitularFirmante getTitularFirmante(Long titularFirmanteId) {
        return titularFirmanteRepository.findById(titularFirmanteId).orElse(null);
    }

    @Override
    public List<TitularFirmante> getTitularesFirmantesByTipo(TitularFirmante.TipoTitular tipoTitular) {
        return titularFirmanteRepository.findByTipoTitular(tipoTitular);
    }

    @Override
    public List<TitularFirmante> getTitularesFirmantesByCuentaId(Long cuentaId) 
    {
        return titularFirmanteRepository.findByCuentaId(cuentaId);
    }

    @Override
    public TitularFirmante updateTitularFirmante(Long idTitularFirmante, TitularFirmante titularFirmante) 
    {
        Optional<TitularFirmante> existingTitularFirmante = titularFirmanteRepository.findById(idTitularFirmante);
        if (existingTitularFirmante.isPresent()) 
        {
            TitularFirmante updatedTitularFirmante = existingTitularFirmante.get();

            // Actualiza los campos que desees del titularFirmante con los valores del parámetro titularFirmante.
            updatedTitularFirmante.setCuentaId(titularFirmante.getCuentaId());
            updatedTitularFirmante.setClienteId(titularFirmante.getClienteId());
            updatedTitularFirmante.setTipoTitular(titularFirmante.getTipoTitular());
            updatedTitularFirmante.setFechaInicioVigencia(titularFirmante.getFechaInicioVigencia());
            updatedTitularFirmante.setFechaFinVigencia(titularFirmante.getFechaFinVigencia());

            // Guarda el titularFirmante actualizado en la base de datos.
            titularFirmanteRepository.save(updatedTitularFirmante);

            return updatedTitularFirmante;
        } 
        else 
        {
            // Si no se encuentra el titularFirmante con el ID proporcionado, puedes manejar el error de alguna manera,
            // por ejemplo, lanzando una excepción o devolviendo null.
            return null;
        }
    }

    @Override
    public boolean deleteTitularFirmante(Long idTitularFirmante) 
    {
        Optional<TitularFirmante> titularFirmante = titularFirmanteRepository.findById(idTitularFirmante);
        if (titularFirmante.isPresent()) 
        {
            titularFirmanteRepository.delete(titularFirmante.get());
            return true; // Éxito en la eliminación.
        } 
        else 
        {
            // Si no se encuentra el titularFirmante con el ID proporcionado, puedes manejar el error de alguna manera,
            // por ejemplo, lanzando una excepción o devolviendo false.
            return false;
        }
    }
}