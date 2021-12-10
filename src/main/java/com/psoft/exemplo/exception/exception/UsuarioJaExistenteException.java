package com.psoft.exemplo.exception.exception;

import javax.persistence.EntityExistsException;

public class UsuarioJaExistenteException extends EntityExistsException {

    public UsuarioJaExistenteException(String nome) {
        super(String.format("Usuário %s já cadastrado!", nome));
    }
}
