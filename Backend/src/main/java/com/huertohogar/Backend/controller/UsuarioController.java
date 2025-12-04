package com.huertohogar.Backend.controller;

import com.huertohogar.Backend.model.Usuario;
import com.huertohogar.Backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // --- YA NO NECESITAMOS LOGIN NI REGISTER AQUÍ (Están en AuthController) ---

    // 1. GET: Ver todos los usuarios
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    // 2. GET: Ver un usuario específico por ID
    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    }

    // 3. PUT: Actualizar un usuario existente
    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(id, usuario);
    }

    // 4. DELETE: Borrar un usuario
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }
}