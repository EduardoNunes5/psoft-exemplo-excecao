package com.psoft.exemplo.exception.repository;

import com.psoft.exemplo.exception.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
