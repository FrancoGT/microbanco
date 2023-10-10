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
    TitularFirmante updateTitularFirmante(Long idTitularFirmante, TitularFirmante titularFirmante);
    boolean deleteTitularFirmante(Long idTitularFirmante);
}