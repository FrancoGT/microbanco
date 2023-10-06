package com.mcvs.titularfirmante.entity;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "titularesfirmantes")
@Data
public class TitularFirmante implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "titular_id")
    private Long titularId;

    @Column(name = "cuenta_id")
    private Long cuentaId;

    @Column(name = "cliente_id")
    private Long clienteId;
    public enum TipoTitular 
    {
        titular,
        firmante
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_titular")
    private TipoTitular tipoTitular;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_inicio_vigencia")
    private Date fechaInicioVigencia;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_fin_vigencia")
    private Date fechaFinVigencia;

    // No es necesario escribir getters, setters o constructores,
    // Lombok generará automáticamente estos métodos.
}