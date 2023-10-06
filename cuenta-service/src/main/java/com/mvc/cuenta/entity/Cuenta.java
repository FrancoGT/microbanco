package com.mvc.cuenta.entity;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "cuentas")
@Data
public class Cuenta implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuenta_id")
    private Long cuentaId;

    @Column(name = "cliente_id")
    private Long clienteId;

    public enum TipoCuenta 
    {
        ahorro,
        cuenta_corriente,
        plazo_fijo
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cuenta")
    private TipoCuenta tipoCuenta;

    @Column(name = "comision_mantenimiento")
    private BigDecimal comisionMantenimiento;

    @Column(name = "limite_movimientos_mensuales")
    private Integer limiteMovimientosMensuales;

    @Column(name = "dia_movimiento")
    private Integer diaMovimiento;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_apertura")
    private Date fechaApertura;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_cierre")
    private Date fechaCierre;

    @Column(name = "saldo_inicial")
    private BigDecimal saldoInicial;

    // Los getters, setters y constructores son generados automáticamente por Lombok.
}