package com.br.imobiliaria.services;

import com.br.imobiliaria.dto.request.ClienteCreateDTO;
import com.br.imobiliaria.entity.Cliente;
import com.br.imobiliaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(ClienteCreateDTO clienteCreateDTO){
        
    }

}
