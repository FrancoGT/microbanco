package com.mcvs.titularfirmante.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mcvs.titularfirmante.entity.TitularFirmante;
import com.mcvs.titularfirmante.repository.TitularFirmanteRepository;
import java.util.List;

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
    public List<TitularFirmante> getAllTitularesFirmantes() {
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
    public List<TitularFirmante> getTitularesFirmantesByCuentaId(Long cuentaId) {
        return titularFirmanteRepository.findByCuentaId(cuentaId);
    }
}