package com.mvc.tarjetacredito.entity;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "tarjetascredito")
@Data
public class TarjetaCredito implements Serializable 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tarjeta_id")
    private Long tarjetaId;

    @Column(name = "cliente_id")
    private Long clienteId;

    public enum TipoTarjeta 
    {
        personal,
        empresarial
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_tarjeta")
    private TipoTarjeta tipoTarjeta;

    @Column(name = "limite_credito")
    private BigDecimal limiteCredito;

    @Column(name = "saldo_actual")
    private BigDecimal saldoActual;

    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;

    @Column(name = "numero_de_cuotas")
    private Integer numeroDeCuotas;

    // No es necesario escribir getters, setters o constructores,
    // Lombok generará automáticamente estos métodos.
}