package com.huertohogar.Backend.controller;

import com.huertohogar.Backend.model.Usuario;
import com.huertohogar.Backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    // Recibe el Usuario (con email, username, y password) y lo registra
    @PostMapping("/register")
    public Usuario registrar(@RequestBody Usuario usuario) {
        return usuarioService.registrar(usuario);
    }

    // Recibe el Usuario (con email y password) y extrae solo esos dos campos para el login
    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario usuario) {
        // Usa el email y el password, ignorando cualquier otro campo del DTO (como el nuevo 'username')
        return usuarioService.login(usuario.getEmail(), usuario.getPassword());
    }
}