package com.huertohogar.Backend.repository;

import com.huertohogar.Backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmailAndPassword(String email, String password);
    Usuario findByEmail(String email);
}