package com.voabrasil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voabrasil.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
