package br.com.phpmaschio.hobbistory.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.phpmaschio.hobbistory.models.DTOs.CreateUsuarioDto;
import br.com.phpmaschio.hobbistory.models.DTOs.ReadUsuarioDto;
import br.com.phpmaschio.hobbistory.services.UsuarioService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping()
    public ResponseEntity<ReadUsuarioDto> postMethodName(@RequestBody @Valid CreateUsuarioDto createUsuarioDTO) {
        return new ResponseEntity<>(this.usuarioService.registrarUsuario(createUsuarioDTO), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ReadUsuarioDto>> buscarUsuarios() {
        return new ResponseEntity<>(this.usuarioService.buscarUsuarios(),HttpStatus.OK);
    }
    

}
