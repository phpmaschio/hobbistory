package br.com.phpmaschio.hobbistory.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.phpmaschio.hobbistory.exceptions.NotFoundException;
import br.com.phpmaschio.hobbistory.models.Usuario;
import br.com.phpmaschio.hobbistory.models.DTOs.CreateUsuarioDto;
import br.com.phpmaschio.hobbistory.models.DTOs.ReadUsuarioDto;
import br.com.phpmaschio.hobbistory.repositories.UsuarioRepository;
import tools.jackson.databind.ObjectMapper;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper mapper;

    public UsuarioService(UsuarioRepository usuarioRepository, ObjectMapper mapper) {
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
    }

    public ReadUsuarioDto registrarUsuario(CreateUsuarioDto createUsuarioDto) {
        Usuario usuario = mapper.convertValue(createUsuarioDto, Usuario.class);
        return mapper.convertValue(this.usuarioRepository.save(usuario), ReadUsuarioDto.class);
    }

    public Usuario buscaUsuarioPorLogin(String login) {
        Optional<Usuario> usuario = this.usuarioRepository.findByLogin(login);
        if (usuario.isPresent()) {
            return usuario.get();
        }
        throw new NotFoundException("Usuario não encontrado");
    }
}
