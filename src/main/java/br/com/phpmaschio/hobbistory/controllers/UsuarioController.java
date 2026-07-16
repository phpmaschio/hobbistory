package br.com.phpmaschio.hobbistory.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.phpmaschio.hobbistory.exceptions.NotFoundException;
import br.com.phpmaschio.hobbistory.models.DTOs.CreateUsuarioDto;
import br.com.phpmaschio.hobbistory.services.UsuarioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping()
    public ResponseEntity<?> postMethodName(@RequestBody CreateUsuarioDto createUsuarioDTO ) {
        try{
            return new ResponseEntity<>(this.usuarioService.registrarUsuario(createUsuarioDTO), HttpStatus.OK);
        }
        catch(NotFoundException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
