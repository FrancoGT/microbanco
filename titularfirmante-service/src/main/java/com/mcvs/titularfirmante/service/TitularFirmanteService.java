package com.mcvs.titularfirmante.service;
import com.mcvs.titularfirmante.entity.TitularFirmante;
import java.util.List;

public interface TitularFirmanteService 
{
    TitularFirmante saveTitularFirmante(TitularFirmante titularFirmante);
    List<TitularFirmante> getAllTitularesFirmantes();
    TitularFirmante getTitularFirmante(Long titularFirmanteId);
    List<TitularFirmante> getTitularesFirmantesByTipo(TitularFirmante.TipoTitular tipoTitular);
    List<TitularFirmante> getTitularesFirmantesByCuentaId(Long cuentaId);
    // Agrega otros métodos personalizados según tus necesidades.
}