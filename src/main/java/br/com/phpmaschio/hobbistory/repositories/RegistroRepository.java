package br.com.phpmaschio.hobbistory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.phpmaschio.hobbistory.models.Registro;
public interface RegistroRepository extends JpaRepository<Registro, Long> {
    List<Registro> findByPassatempoId(Long passatempoId);
}
