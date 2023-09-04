package com.eddy.chiriboga.kruger.inventariovacunacion.repository;

import com.eddy.chiriboga.kruger.inventariovacunacion.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

}
