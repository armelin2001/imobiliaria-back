package com.br.imobiliaria.entity.enums;

public enum TipoImoveis {

    APARTAMENTO("Apartamento"),
    STUDIO("Studio"),
    FAZENDA("Fazenda"),
    CASA("Casa");

    private String desc;

    TipoImoveis(String desc){
        this.desc = desc;
    }

    public String getDesc(){
        return this.desc;
    }
}
