package com.mcvs.productocredito.entity;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "productoscredito")
@Data
public class ProductoCredito implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credito_id")
    private Long creditoId;

    @Column(name = "cliente_id")
    private Long clienteId; // Propiedad para mantener el ID del cliente
    public enum TipoCredito 
    {
    	personal,
    	empresarial
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_credito")
    private TipoCredito tipoCredito;

    @Column(name = "tasa_interes")
    private BigDecimal tasaInteres;

    @Column(name = "plazo")
    private int plazo;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;

    // No es necesario escribir getters, setters o constructores,
    // Lombok generará automáticamente estos métodos.
}