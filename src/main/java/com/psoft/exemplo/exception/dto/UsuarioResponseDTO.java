package com.psoft.exemplo.exception.dto;

import com.psoft.exemplo.exception.entity.Usuario;

public class UsuarioResponseDTO {

    private Long id;

    private String nome;

    private Integer idade;

    private String username;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(Long id, String nome, Integer idade, String username) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.username = username;
    }

    public UsuarioResponseDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.idade = usuario.getIdade();
        this.username = usuario.getUsername();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
