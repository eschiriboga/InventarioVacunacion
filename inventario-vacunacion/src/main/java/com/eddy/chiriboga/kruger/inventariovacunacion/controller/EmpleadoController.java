package com.eddy.chiriboga.kruger.inventariovacunacion.controller;

import com.eddy.chiriboga.kruger.inventariovacunacion.entity.Usuario;
import com.eddy.chiriboga.kruger.inventariovacunacion.service.UsuarioService;
import com.eddy.chiriboga.kruger.inventariovacunacion.service.VacunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private VacunaService vacunaService;
    @PutMapping("/update/empleado/{usuarioId}")
    public ResponseEntity<Object> createUsuario(@RequestBody Usuario usuario) {
        Usuario empleado = new Usuario();
        empleado.setDireccionDomicilio(usuario.getDireccionDomicilio());
        empleado.setTelefonoMovil(usuario.getTelefonoMovil());
        Usuario createdUsuario = usuarioService.creatUsuario(empleado);
        if (createdUsuario != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUsuario);
        } else {
            String errorMessage = "No se pudo crear el usuario";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    @PutMapping("/update/vacuna/{userId}")
    public ResponseEntity<?> updateEmpleadoVacuna(@RequestBody Usuario usuario, @PathVariable Long userId){
        Usuario usuarioExist = usuarioService.getUsuarioById(userId);
        if(usuarioExist == null){
            String errorMessage = "Usuario no encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        usuarioExist.setEstadoVacuncacion(true);

        return  ResponseEntity.ok(usuarioExist);

    }

}
