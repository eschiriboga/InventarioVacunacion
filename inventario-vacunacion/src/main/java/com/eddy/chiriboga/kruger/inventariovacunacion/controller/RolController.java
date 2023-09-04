package com.eddy.chiriboga.kruger.inventariovacunacion.controller;

import com.eddy.chiriboga.kruger.inventariovacunacion.entity.Rol;
import com.eddy.chiriboga.kruger.inventariovacunacion.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
public class RolController {
    @Autowired
    private RolService rolService;

    @GetMapping
    public ResponseEntity<List<Rol>> getAllRoles() {
        List<Rol> roles = rolService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{rolId}")
    public ResponseEntity<Object> getRole(@PathVariable Long rolId) {
        Rol rol = rolService.getRolById(rolId);
        if (rol != null) {
            return ResponseEntity.ok(rol);
        } else {
            String errorMessage = "Rol no encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PostMapping
    public ResponseEntity<Object> createRole(@RequestBody Rol rol) {
        Rol createdRol = rolService.creatRol(rol);
        if (createdRol != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdRol);
        } else {
            String errorMessage = "No se pudo crear el rol";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    @PutMapping("/{rolId}")
    public ResponseEntity<Object> updateRole(@PathVariable Long rolId, @RequestBody Rol updatedRole) {
        Rol rol = rolService.updateRol(rolId, updatedRole);
        if (rol != null) {
            return ResponseEntity.ok(rol);
        } else {
            String errorMessage = "Rol no encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @DeleteMapping("/{rolId}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long rolId) {
        boolean deleted = rolService.deleteRol(rolId);
        if (deleted) {
            String successMessage = "Rol eliminado exitosamente";
            return ResponseEntity.ok(successMessage);
        } else {
            String errorMessage = "Rol no encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
}
