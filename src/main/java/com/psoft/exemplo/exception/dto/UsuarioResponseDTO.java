package com.psoft.exemplo.exception.dto;

public class UsuarioResponseDTO {

    private String nome;

    private String username;

    private String password;

    private Integer idade;

    public UsuarioResponseDTO(String nome, String username, String password, Integer idade) {
        this.nome = nome;
        this.username = username;
        this.password = password;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
