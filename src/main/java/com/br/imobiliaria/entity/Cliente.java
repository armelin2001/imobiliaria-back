package com.br.imobiliaria.entity;

import com.br.imobiliaria.dto.request.ClienteCreateDTO;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document("Cliente")
public class Cliente {

    @Id
    private String id;

    private String nome;
    private String cpf;
    private String email;
    // TODO implementar senha de cliente


    public Cliente() {
    }

    public Cliente(ClienteCreateDTO clienteCreateDTO){
        this.nome = clienteCreateDTO.getNome();
        this.cpf = clienteCreateDTO.getCpf();
        this.email = clienteCreateDTO.getEmail();
    }

    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
