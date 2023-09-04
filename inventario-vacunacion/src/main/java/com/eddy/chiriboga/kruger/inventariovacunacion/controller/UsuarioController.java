package com.eddy.chiriboga.kruger.inventariovacunacion.controller;

import com.eddy.chiriboga.kruger.inventariovacunacion.entity.Usuario;
import com.eddy.chiriboga.kruger.inventariovacunacion.service.UsuarioService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }
    @GetMapping("/{usuarioId}")
    public ResponseEntity<Object> getUsuario(@PathVariable Long usuarioId) {
        Usuario usuario = usuarioService.getUsuarioById(usuarioId);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            String errorMessage = "Usuario no encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }


    }
    /**
     * Para empezar de crean usuarios, solo los Administradores pueden crear usuarios
     * Se registraran la cedula, nombre,apellido y correo electronico
     * del empleado.
     * El username se crea: se forma con el nombre y apellido del usuario
     * El password se genera solo y esta encriptado.
     */
    @PostMapping("/creat/empleado")
    public ResponseEntity<Object> createUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.setCedula(usuario.getCedula());
        usuarioNuevo.setNombre(usuario.getNombre());
        usuarioNuevo.setApellido(usuario.getApellido());
        usuarioNuevo.setCorreo(usuario.getCorreo());
        usuarioNuevo.setNombreUsuario(usuario.getNombre()+"_"+usuario.getApellido());
        usuarioNuevo.setPassword(UUID.randomUUID().toString().substring(0, 8));
        Usuario createdUsuario = usuarioService.creatUsuario(usuarioNuevo);
        if (createdUsuario != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUsuario);
        } else {
            String errorMessage = "No se pudo crear el usuario";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    @PutMapping("/{usuarioId}")
    public ResponseEntity<Object> updateRole(@PathVariable Long usuarioId, @RequestBody Usuario updatedUsuario) {
        Usuario usuario = usuarioService.updateUsuario(usuarioId,updatedUsuario);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            String errorMessage = "Usuario no encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long usuarioId) {
        boolean deleted = usuarioService.deletUsuario(usuarioId);
        if (deleted) {
            String successMessage = "Usuario eliminado exitosamente";
            return ResponseEntity.ok(successMessage);
        } else {
            String errorMessage = "Usuario no encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

}
