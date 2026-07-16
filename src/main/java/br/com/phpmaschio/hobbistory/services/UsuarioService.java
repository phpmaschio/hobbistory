package br.com.phpmaschio.hobbistory.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.phpmaschio.hobbistory.exceptions.NotFoundException;
import br.com.phpmaschio.hobbistory.models.Usuario;
import br.com.phpmaschio.hobbistory.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario registrarUsuario(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public Usuario buscaUsuarioPorLogin(String login) {
        Optional<Usuario> usuario = this.usuarioRepository.findByLogin(login);
        if (usuario.isPresent()) {
            return usuario.get();
        }
        throw new NotFoundException("Usuario não encontrado");
    }
}
