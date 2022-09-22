package com.br.imobiliaria.dto.response;

public class RetornoGenerico {
    private String staus;
    private Object obj;
    private String mensagem;

    public RetornoGenerico(String staus, String mensagem) {
        this.staus = staus;
        this.mensagem = mensagem;
    }

    public RetornoGenerico(String staus, Object obj) {
        this.staus = staus;
        this.obj = obj;
    }

    public String getStaus() {
        return staus;
    }

    public void setStaus(String staus) {
        this.staus = staus;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
