package com.br.imobiliaria.dto.response;

public class RetornoGenericoErro {
    private String mensagem;

    public RetornoGenericoErro(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
