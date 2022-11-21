package com.br.imobiliaria.dto.request;

public class AlugaDto {
    private String idImovel;
    private String idCliente;

    public AlugaDto(String idImovel, String idCliente) {
        this.idImovel = idImovel;
        this.idCliente = idCliente;
    }
    public AlugaDto(){}
    public String getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(String idImovel) {
        this.idImovel = idImovel;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
}
