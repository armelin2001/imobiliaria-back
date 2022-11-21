package com.br.imobiliaria.dto.request;

public class LoginDto {
    private String id;
    private String email;
    private String senha;

    public LoginDto(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public LoginDto(String id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }
    public LoginDto(){}
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
