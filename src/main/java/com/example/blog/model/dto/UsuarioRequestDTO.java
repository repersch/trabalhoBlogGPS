package com.example.blog.model.dto;

public class UsuarioRequestDTO {

    private String email;
    private String senha;

    public UsuarioRequestDTO() {
    }

    public UsuarioRequestDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
