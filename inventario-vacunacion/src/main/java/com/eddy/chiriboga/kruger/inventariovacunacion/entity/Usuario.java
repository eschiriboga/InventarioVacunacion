package com.eddy.chiriboga.kruger.inventariovacunacion.entity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;
    @NotBlank(message = "El campo cedula es requerida")
    @NotNull(message = "El campo cedula no puede ser nulo")
    @Pattern(regexp = "\\d+", message = "El campo cedula debe contener solo números")
    private String cedula;

    @NotBlank(message = "El campo nombre es requerido")
    @NotNull(message = "El campo nombre no puede ser nulo")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "El campo Nombre solo debe contener letras")
    private String nombre;

    @NotBlank(message = "El campo nombre es requerido")
    @NotNull(message = "El campo nombre no puede ser nulo")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "El campo Apellido solo debe contener letras")
    private String apellido;

    @NotBlank(message = "El campo email es requerido")
    @NotNull(message = "El campo email no puede ser nulo")
    @Email(message = "Correo no válido")
    private String correo;

    private Date fechaNacimiento;
    private String direccionDomicilio;
    private String telefonoMovil;
    private boolean estadoVacuncacion;
    private String nombreUsuario;
    private String password;
    @OneToOne
    @JoinColumn(name = "roleId")
    private Rol rol;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private List<UsuarioVacuna> vacunas;


}
