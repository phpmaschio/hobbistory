package br.com.phpmaschio.hobbistory.services;

import br.com.phpmaschio.hobbistory.repositories.PassaTempoRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.phpmaschio.hobbistory.exceptions.NotFoundException;
import br.com.phpmaschio.hobbistory.models.PassaTempo;

@Service
public class PassaTempoService {
    private final PassaTempoRepository passaTempoRepository;

    public PassaTempoService(PassaTempoRepository passaTempoRepository){
        this.passaTempoRepository = passaTempoRepository;
    }

    public PassaTempo registrarPassaTempo(PassaTempo passaTempo){
        return passaTempoRepository.save(passaTempo);
    }

    public PassaTempo retornaTodosPassaTempos(Long id){
        Optional<PassaTempo> passaTempo =  this.passaTempoRepository.findById(id);
        if(passaTempo.isPresent()) return passaTempo.get();
        throw new NotFoundException("Passa tempo não encontrado");
    }

    public List<PassaTempo> retornaTodosPassaTempos(){
        return this.passaTempoRepository.findAll();
    }
    
}
