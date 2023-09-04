package com.eddy.chiriboga.kruger.inventariovacunacion.service;

import com.eddy.chiriboga.kruger.inventariovacunacion.entity.Usuario;
import com.eddy.chiriboga.kruger.inventariovacunacion.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }


    public Usuario getUsuarioById(Long usuarioId) {
        return usuarioRepository.findById(usuarioId).orElse(null);
    }

    public Usuario creatUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Long usuarioId, Usuario updateUsuario) {
        Usuario existingUsuario = usuarioRepository.findById(usuarioId).orElse(null);
        if (existingUsuario != null) {
            updateUsuario.setUsuarioId(usuarioId);
            return usuarioRepository.save(updateUsuario);
        }
        return null;
    }

    public boolean deletUsuario(Long usuarioId) {
        if (usuarioRepository.existsById(usuarioId)) {
            usuarioRepository.deleteById(usuarioId);
            return true;
        }
        return false;
    }
}
