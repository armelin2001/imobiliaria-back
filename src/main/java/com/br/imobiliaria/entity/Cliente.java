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
    private String senha;


    public Cliente() {
    }

    public Cliente(ClienteCreateDTO clienteCreateDTO){
        this.nome = clienteCreateDTO.getNome();
        this.cpf = clienteCreateDTO.getCpf();
        this.email = clienteCreateDTO.getEmail();
        this.senha = clienteCreateDTO.getSenha();
    }

    public Cliente(String nome, String cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
