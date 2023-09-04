package com.eddy.chiriboga.kruger.inventariovacunacion.repository;

import com.eddy.chiriboga.kruger.inventariovacunacion.entity.Vacuna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacunaRepository extends JpaRepository<Vacuna,Long> {
}
