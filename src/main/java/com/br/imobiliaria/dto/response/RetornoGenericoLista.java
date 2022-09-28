package com.br.imobiliaria.dto.response;

import java.util.List;

public class RetornoGenericoLista {
    private List<Object> retornoList;


    public RetornoGenericoLista(List<Object> retornoList) {
        this.retornoList = retornoList;
    }

    public List<Object> getRetornoList() {
        return retornoList;
    }

    public void setRetornoList(List<Object> retornoList) {
        this.retornoList = retornoList;
    }
}
