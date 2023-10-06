package com.msvc.cliente.entity;
import java.util.Date;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clientes")
@Data
public class Cliente 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoCliente tipo;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    public enum TipoCliente 
    {
        personal,
        empresarial
    }
}