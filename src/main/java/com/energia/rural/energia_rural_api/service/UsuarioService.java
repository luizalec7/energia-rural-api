package com.energia.rural.energia_rural_api.service;

import com.energia.rural.energia_rural_api.model.Usuario;
import com.energia.rural.energia_rural_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarUsuarioPorId(Long usuarioId) {
        return usuarioRepository.findById(usuarioId);
    }
}
