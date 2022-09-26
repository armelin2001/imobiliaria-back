package com.br.imobiliaria.dto.response;

import java.util.List;

public class RetornoGenerico {
    private Object retorno;
    private String mensagem;
    private List<Object> retornoList;


    public RetornoGenerico(String mensagem) {
        this.mensagem = mensagem;
    }

    public RetornoGenerico(Object retorno) {
        this.retorno = retorno;
    }

    public RetornoGenerico(List<Object> retornoList) {
        this.retornoList = retornoList;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Object getRetorno() {
        return retorno;
    }

    public void setRetorno(Object retorno) {
        this.retorno = retorno;
    }

    public List<Object> getRetornoList() {
        return retornoList;
    }

    public void setRetornoList(List<Object> retornoList) {
        this.retornoList = retornoList;
    }
}
