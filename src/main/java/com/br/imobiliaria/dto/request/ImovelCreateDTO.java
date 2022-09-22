package com.br.imobiliaria.dto.request;

import com.br.imobiliaria.entity.Corretor;
import com.br.imobiliaria.entity.enums.TipoImoveis;

import java.util.Date;

public class ImovelCreateDTO {

    private TipoImoveis tipoImoveis;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String cep;
    private String complemento;
    private float valorBase;
    private float valorNegociado;
    private Date criacao;
    private Date venda;
    private boolean reservado;
    private String corretorAnunciadoId;

    public ImovelCreateDTO(TipoImoveis tipoImoveis,
                           String estado, String cidade,
                           String bairro, String rua,
                           String cep, String complemento,
                           float valorBase, float valorNegociado,
                           Date criacao, Date venda,
                           boolean reservado,
                           String corretorAnunciadoId) {
        this.tipoImoveis = tipoImoveis;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.cep = cep;
        this.complemento = complemento;
        this.valorBase = valorBase;
        this.valorNegociado = valorNegociado;
        this.criacao = criacao;
        this.venda = venda;
        this.reservado = reservado;
        this.corretorAnunciadoId = corretorAnunciadoId;
    }

    public TipoImoveis getTipoImoveis() {
        return tipoImoveis;
    }

    public void setTipoImoveis(TipoImoveis tipoImoveis) {
        this.tipoImoveis = tipoImoveis;
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

    public float getValorBase() {
        return valorBase;
    }

    public void setValorBase(float valorBase) {
        this.valorBase = valorBase;
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

    public String getCorretorAnunciadoId() {
        return corretorAnunciadoId;
    }

    public void setCorretorAnunciadoId(String corretorAnunciadoId) {
        this.corretorAnunciadoId = corretorAnunciadoId;
    }
}
