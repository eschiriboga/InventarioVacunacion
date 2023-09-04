package com.eddy.chiriboga.kruger.inventariovacunacion.service;

import com.eddy.chiriboga.kruger.inventariovacunacion.entity.Vacuna;
import com.eddy.chiriboga.kruger.inventariovacunacion.repository.VacunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VacunaService {
    @Autowired
    private VacunaRepository vacunaRepository;

    public List<Vacuna> getAllVacunas() {
        return vacunaRepository.findAll();
    }

    public Vacuna getVacunaById(Long vacunaId) {
        return vacunaRepository.findById(vacunaId).orElse(null);
    }

    public Vacuna createVacuna(Vacuna vacuna) {
        return vacunaRepository.save(vacuna);
    }

    public Vacuna updateVacuna(Long vacunaId, Vacuna updateVacuna) {
        Vacuna existingVacuna = vacunaRepository.findById(vacunaId).orElse(null);
        if (existingVacuna != null) {
            updateVacuna.setVacunaId(vacunaId);
            return vacunaRepository.save(updateVacuna);
        }
        return null;
    }

    public boolean deletVacuna(Long vacunaId) {
        if (vacunaRepository.existsById(vacunaId)) {
            vacunaRepository.deleteById(vacunaId);
            return true;
        }
        return false;
    }

}
