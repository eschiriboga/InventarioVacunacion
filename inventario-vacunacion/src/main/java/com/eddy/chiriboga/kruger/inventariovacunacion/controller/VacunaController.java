package com.eddy.chiriboga.kruger.inventariovacunacion.controller;

import com.eddy.chiriboga.kruger.inventariovacunacion.entity.Usuario;
import com.eddy.chiriboga.kruger.inventariovacunacion.entity.Vacuna;
import com.eddy.chiriboga.kruger.inventariovacunacion.service.VacunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacuna")
public class VacunaController {
    @Autowired
    private VacunaService vacunaService;
    @GetMapping
    public ResponseEntity<List<Vacuna>> getAllVacunas() {
        List<Vacuna> vacunas = vacunaService.getAllVacunas();
        return ResponseEntity.ok(vacunas);
    }
    @GetMapping("/{vacunaId}")
    public ResponseEntity<Object> getVacuna(@PathVariable Long vacunaId) {
        Vacuna vacuna = vacunaService.getVacunaById(vacunaId);
        if (vacuna != null) {
            return ResponseEntity.ok(vacuna);
        } else {
            String errorMessage = "Vacuna no encontrada";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }


    }
    @PostMapping
    public ResponseEntity<Object> createVacuna(@RequestBody Vacuna vacuna) {
        Vacuna createdVacuna = vacunaService.createVacuna(vacuna);
        if (createdVacuna != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdVacuna);
        } else {
            String errorMessage = "No se pudo crear la vacuna";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }
    @PutMapping("/{vacunaId}")
    public ResponseEntity<Object> updateVacuna(@PathVariable Long vacunaId, @RequestBody Vacuna updatedVacuna) {
        Vacuna vacuna = vacunaService.updateVacuna(vacunaId,updatedVacuna);
        if (vacuna != null) {
            return ResponseEntity.ok(vacuna);
        } else {
            String errorMessage = "Vacuna no encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
    @DeleteMapping("/{vacunaId}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long vacunaId) {
        boolean deleted = vacunaService.deletVacuna(vacunaId);
        if (deleted) {
            String successMessage = "Vacuna eliminada exitosamente";
            return ResponseEntity.ok(successMessage);
        } else {
            String errorMessage = "Vacuna no encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

}
