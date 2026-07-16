package br.com.phpmaschio.hobbistory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.phpmaschio.hobbistory.exceptions.NotFoundException;
import br.com.phpmaschio.hobbistory.models.Registro;
import br.com.phpmaschio.hobbistory.repositories.RegistroRepository;

@Service
public class RegistroService {
    private final RegistroRepository registroRepository;

    public RegistroService(RegistroRepository registroRepository) {
        this.registroRepository = registroRepository;
    }

    public Registro registrarRegistro(Registro registro){
        return this.registroRepository.save(registro);
    }

    public List<Registro> buscarRegistrosPorPassatempo(Long passatempoId){
        return this.registroRepository.findByPassatempoId(passatempoId);
    }

    public Registro buscarRegistroPorId(Long registroId){
        Optional<Registro> registro = this.registroRepository.findById(registroId);
        if(registro.isPresent()) return registro.get();
        throw new NotFoundException("Registro não encontrado");
    }
}
