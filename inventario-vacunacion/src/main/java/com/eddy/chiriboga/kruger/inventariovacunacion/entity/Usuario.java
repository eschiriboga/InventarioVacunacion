package com.eddy.chiriboga.kruger.inventariovacunacion.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Getter @Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @NotNull(message = "El campo cedula no puede ser nulo")
    @Pattern(regexp = "\\d+", message = "El campo cedula debe contener solo números")
    @Size(min = 10, max = 10, message = "El número de cédula debe tener 10 digitos")
    private String cedula;


    @NotNull(message = "El campo nombre no puede ser nulo")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "El campo Nombre solo debe contener letras")
    private String nombre;

    @NotNull(message = "El campo nombre no puede ser nulo")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "El campo Apellido solo debe contener letras")
    private String apellido;

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

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "usuario_id")
//    private List<UsuarioVacuna> vacunas;


}
