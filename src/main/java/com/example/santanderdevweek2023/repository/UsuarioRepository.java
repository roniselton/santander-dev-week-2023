package com.example.santanderdevweek2023.repository;

import com.example.santanderdevweek2023.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
