package br.com.phpmaschio.hobbistory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.phpmaschio.hobbistory.models.Passatempo;

public interface PassatempoRepository extends JpaRepository<Passatempo,Long> {

}
