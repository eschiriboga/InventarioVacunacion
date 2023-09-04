package com.eddy.chiriboga.kruger.inventariovacunacion.controller;

import com.eddy.chiriboga.kruger.inventariovacunacion.entity.ResponseuserByNameVaccune;
import com.eddy.chiriboga.kruger.inventariovacunacion.entity.Usuario;
import com.eddy.chiriboga.kruger.inventariovacunacion.entity.UsuarioVacuna;
import com.eddy.chiriboga.kruger.inventariovacunacion.service.UsuarioVacunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/apis")
public class ConsultasController {
    @Autowired
    private UsuarioVacunaService usuarioVacunaService;
    /* empleados filtrados por estado de vacunación*/
    @GetMapping(value = "/vacunados")
    public ResponseEntity<List<Usuario>> getAllVacunados() {
        List<UsuarioVacuna> usuariosVacunados = usuarioVacunaService.getAllUsuarioVacunas();
        List<Usuario> listUsuario = new ArrayList<>();
        for (UsuarioVacuna usuarioVacuna : usuariosVacunados){
            listUsuario.add(usuarioVacuna.getUsuario());
        }
        return ResponseEntity.ok(listUsuario);
    }
    /* empleados filtrados tipo de vacuna*/
    @GetMapping(value = "/vacunados/byNombreVacuna/{nombreVacuna}")
    public ResponseEntity<List<ResponseuserByNameVaccune>> getAllVacunados(@PathVariable(name = "nombreVacuna") String nombreVacuna) {
        List<UsuarioVacuna> usuariosVacunados = usuarioVacunaService.getAllUsuarioByVacuna(nombreVacuna);
        List<ResponseuserByNameVaccune> listUsuario = new ArrayList<>();
        for (UsuarioVacuna usuarioVacuna : usuariosVacunados){
            ResponseuserByNameVaccune responseuserByNameVaccune= new ResponseuserByNameVaccune();
            responseuserByNameVaccune.setUsuario(usuarioVacuna.getUsuario());
            responseuserByNameVaccune.setVacuna(usuarioVacuna.getVacuna());
            listUsuario.add(responseuserByNameVaccune);
        }
        return ResponseEntity.ok(listUsuario);
    }
    /*empleados filtrados por rango de fecha de vacunacion*/
    @GetMapping(value = "/vacunados/ByDate")
    public ResponseEntity<List<Usuario>> getAllVacunadosByDate(@RequestParam String fechaInicio,@RequestParam String fechaFin) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dateIni;
        Date dateFi;
        try {
            dateIni = formatter.parse(fechaInicio);
            dateFi = formatter.parse(fechaFin);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        List<UsuarioVacuna> usuariosVacunados = usuarioVacunaService.getUsuarioByFecha(dateIni,dateFi);
        List<Usuario> listUsuario = new ArrayList<>();
        for (UsuarioVacuna usuarioVacuna : usuariosVacunados){
            listUsuario.add(usuarioVacuna.getUsuario());
        }
        return ResponseEntity.ok(listUsuario);
    }
}
