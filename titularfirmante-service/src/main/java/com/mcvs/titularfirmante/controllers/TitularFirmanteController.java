package com.mcvs.titularfirmante.controllers;

import com.mcvs.titularfirmante.entity.TitularFirmante;
import com.mcvs.titularfirmante.entity.TitularFirmante.TipoTitular;
import com.mcvs.titularfirmante.service.TitularFirmanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/titularesfirmantes")
public class TitularFirmanteController 
{

    @Autowired
    private TitularFirmanteService titularFirmanteService;

    @PostMapping
    public ResponseEntity<TitularFirmante> guardarTitularFirmante(@RequestBody TitularFirmante titularFirmanteRequest) 
    {
        TitularFirmante titularFirmante = titularFirmanteService.saveTitularFirmante(titularFirmanteRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(titularFirmante);
    }

    @GetMapping("/titularFirmanteId/{titularFirmanteId}")
    public ResponseEntity<TitularFirmante> obtenerTitularFirmante(@PathVariable Long titularFirmanteId) 
    {
        TitularFirmante titularFirmante = titularFirmanteService.getTitularFirmante(titularFirmanteId);
        return ResponseEntity.ok(titularFirmante);
    }

    @GetMapping
    public ResponseEntity<List<TitularFirmante>> listarTitularesFirmantes() 
    {
        List<TitularFirmante> titularesFirmantes = titularFirmanteService.getAllTitularesFirmantes();
        return ResponseEntity.ok(titularesFirmantes);
    }

    @GetMapping("/tipo/{tipoTitular}")
    public ResponseEntity<List<TitularFirmante>> listarTitularesFirmantesPorTipo(@PathVariable String tipoTitular) 
    {
        try 
        {
            TipoTitular tipo = TipoTitular.valueOf(tipoTitular); // Intenta convertir la cadena en un valor del Enum TipoTitular
            List<TitularFirmante> titularesFirmantes = titularFirmanteService.getTitularesFirmantesByTipo(tipo);
            return ResponseEntity.ok(titularesFirmantes);
        } 
        catch (IllegalArgumentException e) 
        {
            // El tipoTitular proporcionado no es válido como Enum TipoTitular.
            // Devuelve una respuesta de error apropiada, por ejemplo, un HttpStatus.BAD_REQUEST.
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/cuenta/{cuentaId}")
    public ResponseEntity<List<TitularFirmante>> listarTitularesFirmantesPorCuentaId(@PathVariable Long cuentaId) 
    {
        List<TitularFirmante> titularesFirmantes = titularFirmanteService.getTitularesFirmantesByCuentaId(cuentaId);
        return ResponseEntity.ok(titularesFirmantes);
    }
}