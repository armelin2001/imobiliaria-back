package com.br.imobiliaria.dto.response;

import com.br.imobiliaria.dto.request.LoginDto;

public class RetornoLogin {

    private String id;
    private String email;
    private boolean ehCorretor;

    public RetornoLogin(String id, String email, boolean ehCorretor) {
        this.id = id;
        this.email = email;
        this.ehCorretor = ehCorretor;
    }
    public RetornoLogin(){}
    public boolean isEhCorretor() {
        return ehCorretor;
    }

    public void setEhCorretor(boolean ehCorretor) {
        this.ehCorretor = ehCorretor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
