package com.psoft.exemplo.exception.exception;

import javax.persistence.EntityNotFoundException;

public class UsuarioNaoEncontradoException extends EntityNotFoundException {

    public UsuarioNaoEncontradoException(String username) {
        super(String.format("Usuario %s não encontrado", username));
    }

    public UsuarioNaoEncontradoException(Long id) {
        super(String.format("Usuario com o id %d não encontrado", id));
    }
}
