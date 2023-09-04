package com.eddy.chiriboga.kruger.inventariovacunacion.service;

import com.eddy.chiriboga.kruger.inventariovacunacion.entity.UsuarioVacuna;
import com.eddy.chiriboga.kruger.inventariovacunacion.repository.UsuarioVacunaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsuarioVacunaService {

    @Autowired
    private UsuarioVacunaRepository usuarioVacunaRepository;

    public List<UsuarioVacuna> getAllUsuarioVacunas(){
        return usuarioVacunaRepository.findAll();
    }

    public UsuarioVacuna getUsuarioVacunaById(Long id){
        return usuarioVacunaRepository.findById(id).orElse(null);
    }
    public UsuarioVacuna createUsuarioVacuna(UsuarioVacuna usuarioVacuna){
        return  usuarioVacunaRepository.save(usuarioVacuna);
    }

    public UsuarioVacuna updateUsuarioVacuna(Long id,UsuarioVacuna usuarioVacuna){
        if(usuarioVacunaRepository.existsById(id)){
            return usuarioVacunaRepository.save(usuarioVacuna);
        }
        return  null;
    }

    public boolean deletUsuarioVacuna(Long id){
        if(usuarioVacunaRepository.existsById(id)){
            usuarioVacunaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
