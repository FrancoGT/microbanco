package com.mcvs.titularfirmante.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mcvs.titularfirmante.entity.TitularFirmante;

@Repository
public interface TitularFirmanteRepository extends JpaRepository<TitularFirmante, Long> 
{
    // No es necesario definir los métodos CRUD básicos, JpaRepository ya los proporciona automáticamente.
    
    // Puedes agregar métodos personalizados según tus necesidades aquí si es necesario.
    
    // Por ejemplo, para buscar titulares/firmantes por tipo de titular:
    List<TitularFirmante> findByTipoTitular(TitularFirmante.TipoTitular tipoTitular);
    
    // O para buscar titulares/firmantes por cuentaId:
    List<TitularFirmante> findByCuentaId(Long cuentaId);
    
    // También puedes agregar métodos para buscar titulares/firmantes por clienteId, fechas de vigencia, etc., según tus requisitos.
}