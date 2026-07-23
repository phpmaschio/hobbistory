package br.com.phpmaschio.hobbistory.services;

import br.com.phpmaschio.hobbistory.repositories.PassatempoRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.phpmaschio.hobbistory.exceptions.NotFoundException;
import br.com.phpmaschio.hobbistory.models.Passatempo;

@Service
public class PassatempoService {
    private final PassatempoRepository passatempoRepository;

    public PassatempoService(PassatempoRepository passatempoRepository){
        this.passatempoRepository = passatempoRepository;
    }

    public Passatempo registrarPassatempo(Passatempo passatempo){
        return passatempoRepository.save(passatempo);
    }

    public Passatempo retornaTodosPassatempos(Long id){
        Optional<Passatempo> passatempo =  this.passatempoRepository.findById(id);
        if(passatempo.isPresent()) return passatempo.get();
        throw new NotFoundException("Passa tempo não encontrado");
    }

    public List<Passatempo> retornaTodosPassatempos(){
        return this.passatempoRepository.findAll();
    }
    
}
