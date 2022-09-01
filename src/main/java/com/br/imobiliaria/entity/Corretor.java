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

    // Campo senha
    // colocar quando implementar o JWT

    public Corretor() {
    }

    public Corretor(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    public Corretor(CorretorCreateDto corretorCreateDto){
        this.nome = corretorCreateDto.getNome();
        this.email = corretorCreateDto.getEmail();
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
}
