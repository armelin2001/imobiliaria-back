package com.br.imobiliaria.entity;

import com.br.imobiliaria.dto.request.CorretorCreateDto;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document("Corretor")
public class Corretor {

    @Id
    private String id;

    private String nome;
    private String email;
    private String senha;

    public Corretor() {
    }

    public Corretor(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    public Corretor(CorretorCreateDto corretorCreateDto){
        this.nome = corretorCreateDto.getNome();
        this.email = corretorCreateDto.getEmail();
        this.senha = corretorCreateDto.getSenha();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
