package com.eddy.chiriboga.kruger.inventariovacunacion.service;

import com.eddy.chiriboga.kruger.inventariovacunacion.entity.Rol;
import com.eddy.chiriboga.kruger.inventariovacunacion.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public List<Rol> getAllRoles() {
        return rolRepository.findAll();
    }

    public Rol getRolById(Long rolId) {
        return rolRepository.findById(rolId).orElse(null);
    }

    public Rol creatRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol updateRol(Long rolId, Rol updateRol) {

        Rol existingRol = rolRepository.findById(rolId).orElse(null);
        if (existingRol != null) {
            existingRol.setNombreRol(updateRol.getNombreRol());
            return rolRepository.save(existingRol);
        }
        return null;
    }

    public boolean deleteRol(Long roldId) {
        if (rolRepository.existsById(roldId)) {
            rolRepository.deleteById(roldId);
            return true;
        }
        return false;
    }
}
