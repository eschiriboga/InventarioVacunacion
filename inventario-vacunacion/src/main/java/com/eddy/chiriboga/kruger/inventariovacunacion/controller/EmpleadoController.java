package com.eddy.chiriboga.kruger.inventariovacunacion.controller;

import com.eddy.chiriboga.kruger.inventariovacunacion.entity.Usuario;
import com.eddy.chiriboga.kruger.inventariovacunacion.entity.UsuarioVacuna;
import com.eddy.chiriboga.kruger.inventariovacunacion.entity.Vacuna;
import com.eddy.chiriboga.kruger.inventariovacunacion.service.UsuarioService;
import com.eddy.chiriboga.kruger.inventariovacunacion.service.UsuarioVacunaService;
import com.eddy.chiriboga.kruger.inventariovacunacion.service.VacunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private VacunaService vacunaService;
    @Autowired
    public UsuarioVacunaService usuarioVacunaService;
    /**
     * Como empleado requiero ingresar al aplicativo para poder
     * actualizar el resto de mi informacion: direccion,telefonomovil
     * estadoVacunacion y fecha de nacimineto
     */
    @PutMapping("/update/empleado/{usuarioId}")
    public ResponseEntity<Object> createUsuario( @RequestBody Usuario usuario,@PathVariable Long usuarioId) {
        Usuario empleado = usuarioService.getUsuarioById(usuarioId);
        empleado.setDireccionDomicilio(usuario.getDireccionDomicilio());
        empleado.setTelefonoMovil(usuario.getTelefonoMovil());
        empleado.setEstadoVacuncacion(usuario.isEstadoVacuncacion());
        empleado.setFechaNacimiento(usuario.getFechaNacimiento());
        Usuario createdUsuario = usuarioService.updateUsuario(usuarioId,empleado);
        if (createdUsuario != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUsuario);
        } else {
            String errorMessage = "No se pudo crear el usuario";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    /*Endpoint que permite la actualizacion del Empleado, ademas de guardar los campos mandatorios*/
    /**
     * Como empleado si registro el estado de vacunacion se creara un
     * registro de vacuna
     */
    @PutMapping("/update/vacuna/{userId}")
    public ResponseEntity<?> updateEmpleadoVacuna(@RequestBody List<UsuarioVacuna> listUsuarioVacuna, @PathVariable Long userId){
        Usuario usuarioExist = usuarioService.getUsuarioById(userId);
        Vacuna vacuna;
        if(usuarioExist==null){
            String errorMessage = "Usuario no encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        if(usuarioExist.isEstadoVacuncacion()){
            for (UsuarioVacuna usuarioVacuna1: listUsuarioVacuna){
                usuarioVacunaService.createUsuarioVacuna(usuarioVacuna1);
            }
            ResponseEntity.ok("Vacunas Regitradas");
        }

        return  ResponseEntity.ok("Usuario Sin Vacunas");
    }

}
