package com.huertohogar.Backend.repository;

import com.huertohogar.Backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Login sigue funcionando con email y password:
    Usuario findByEmailAndPassword(String email, String password);
    Usuario findByEmail(String email);

    // <--- NUEVO (Recomendado para verificar unicidad al registrar)
    Usuario findByUsername(String username);
}