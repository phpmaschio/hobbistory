package br.com.phpmaschio.hobbistory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.phpmaschio.hobbistory.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

}
