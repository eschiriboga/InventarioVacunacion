package com.eddy.chiriboga.kruger.inventariovacunacion.repository;

import com.eddy.chiriboga.kruger.inventariovacunacion.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol,Long> {

    Rol findById(long id);
}
