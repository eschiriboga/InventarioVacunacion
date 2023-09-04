package com.eddy.chiriboga.kruger.inventariovacunacion.repository;

import com.eddy.chiriboga.kruger.inventariovacunacion.entity.UsuarioVacuna;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface UsuarioVacunaRepository extends CrudRepository<UsuarioVacuna,Long> {

    @Query("SELECT us FROM UsuarioVacuna us WHERE us.vacuna.nombreVacuna = :nombreVacuna")
    List<UsuarioVacuna> findUsuarioByVacuna(@Param("nombreVacuna") String nombreVacuna);

    @Query("SELECT us FROM UsuarioVacuna us WHERE us.fechaVacunacion between :fechaInicio and :fechaFin")
    List<UsuarioVacuna> findUsuarioByFecha(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);




}
