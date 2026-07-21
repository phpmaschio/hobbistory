package br.com.phpmaschio.hobbistory.exceptions;

public class UsuarioJaCadastradoException extends RuntimeException {
    public UsuarioJaCadastradoException(String message){
        super(message);
    }
}
