package com.psoft.exemplo.exception.exception;

public class CustomResponseError {

    private String mensagem;

    public CustomResponseError(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
