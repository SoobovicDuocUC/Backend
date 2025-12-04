package com.huertohogar.Backend.service;

import com.huertohogar.Backend.model.Usuario;
import com.huertohogar.Backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 1. LEER TODOS
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // 2. LEER UNO POR ID
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // 3. ACTUALIZAR
    public Usuario updateUsuario(Long id, Usuario usuarioDetalles) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        if (usuario != null) {
            usuario.setEmail(usuarioDetalles.getEmail());
            usuario.setRole(usuarioDetalles.getRole());
            if (usuarioDetalles.getPassword() != null && !usuarioDetalles.getPassword().isEmpty()) {
                usuario.setPassword(passwordEncoder.encode(usuarioDetalles.getPassword()));
            }

            return usuarioRepository.save(usuario);
        }
        return null;
    }


    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}