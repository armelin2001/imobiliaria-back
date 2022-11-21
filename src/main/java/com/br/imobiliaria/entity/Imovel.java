package com.br.imobiliaria.entity;

import com.br.imobiliaria.dto.request.ImovelCreateDTO;
import com.br.imobiliaria.entity.enums.TipoImoveis;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

@Document("Imovel")
public class Imovel {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private TipoImoveis tipoImovel;

    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String cep;
    private String complemento;
    private float valorNegociado;
    private Date criacao;
    private Date venda;
    private boolean reservado;

    @DBRef
    private Corretor corretorAnunciado;
    @DBRef
    private Corretor corretorVenda;
    @DBRef
    private Cliente cliente;


    public Imovel(){}

    public Imovel(TipoImoveis tipoImovel, String estado,
                  String cidade, String bairro, String rua,
                  String cep, String complemento,
                  Corretor corretorAnunciado) {
        this.tipoImovel = tipoImovel;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.cep = cep;
        this.complemento = complemento;
        this.criacao = new Date();
        this.corretorAnunciado = corretorAnunciado;
        this.reservado = false;
    }

    public Imovel(TipoImoveis tipoImovel, String estado,
                  String cidade, String bairro,
                  String rua, String cep, String complemento,
                  float valorBase, float valorNegociado,
                  Date criacao,
                  Corretor corretorAnunciado) {
        this.tipoImovel = tipoImovel;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.cep = cep;
        this.complemento = complemento;
        this.valorNegociado = valorNegociado;
        this.criacao = criacao;
        this.reservado = false;
        this.corretorAnunciado = corretorAnunciado;
    }
    public Imovel(ImovelCreateDTO imovelCreateDTO){
        this.tipoImovel = imovelCreateDTO.getTipoImoveis();
        this.estado = imovelCreateDTO.getEstado();
        this.cidade = imovelCreateDTO.getCidade();
        this.bairro = imovelCreateDTO.getBairro();
        this.rua = imovelCreateDTO.getRua();
        this.cep = imovelCreateDTO.getCep();
        this.complemento = imovelCreateDTO.getComplemento();
        this.valorNegociado = imovelCreateDTO.getValorNegociado();
        this.criacao = imovelCreateDTO.getCriacao();
        this.reservado = false;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoImoveis getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(TipoImoveis tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public float getValorNegociado() {
        return valorNegociado;
    }

    public void setValorNegociado(float valorNegociado) {
        this.valorNegociado = valorNegociado;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }

    public Date getVenda() {
        return venda;
    }

    public void setVenda(Date venda) {
        this.venda = venda;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public Corretor getCorretorAnunciado() {
        return corretorAnunciado;
    }

    public void setCorretorAnunciado(Corretor corretorAnunciado) {
        this.corretorAnunciado = corretorAnunciado;
    }

    public Corretor getCorretorVenda() {
        return corretorVenda;
    }

    public void setCorretorVenda(Corretor corretorVenda) {
        this.corretorVenda = corretorVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}




