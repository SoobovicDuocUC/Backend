package com.huertohogar.Backend.model;

import javax.persistence.*; // CAMBIO AQUÍ: javax en vez de jakarta
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true) // <--- NUEVO: Asegura que el username sea único
    private String username; // <--- NUEVO CAMPO

    private String password;
    private String role; // "ADMIN" o "USER"

    public Usuario() {}

    public Usuario(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Usuario(String email, String username, String password, String role) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // --- MÉTODOS DE SEGURIDAD (UserDetails) ---
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    // IMPORTANTE: Mantenemos el email como el identificador principal para Spring Security.
    public String getUsername() { return email; }

    @Override
    public String getPassword() { return password; }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }

    // --- GETTERS Y SETTERS NORMALES ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getUsernamePropiedad() { return username; }
    public void setUsername(String username) { this.username = username; }
}