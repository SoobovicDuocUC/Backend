package com.huertohogar.Backend.service;

import com.huertohogar.Backend.model.Usuario;
import com.huertohogar.Backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario login(String email, String password) {
        return usuarioRepository.findByEmailAndPassword(email, password);
    }
}