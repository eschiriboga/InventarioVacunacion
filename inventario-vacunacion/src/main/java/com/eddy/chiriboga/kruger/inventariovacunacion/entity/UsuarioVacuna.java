package com.eddy.chiriboga.kruger.inventariovacunacion.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class UsuarioVacuna  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Date fechaVacunacion;
    private Integer dosis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacunaId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Vacuna vacuna;
}
