package com.br.imobiliaria.services;

import com.br.imobiliaria.dto.request.ClienteCreateDTO;
import com.br.imobiliaria.dto.response.RetornoGenerico;
import com.br.imobiliaria.entity.Cliente;
import com.br.imobiliaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public RetornoGenerico saveCliente(ClienteCreateDTO clienteCreateDTO){
        Cliente clienteCreate = new Cliente(clienteCreateDTO);
        return new RetornoGenerico("201", clienteRepository.save(clienteCreate));
    }

    public RetornoGenerico getById(String id){
        boolean clienteEncontrado = clienteRepository.findById(id).isEmpty();
        if(!clienteEncontrado){
            return new RetornoGenerico("200", clienteRepository.findById(id));
        }
        else{
            return new RetornoGenerico("404", "Cliente não encontrado!");
        }
    }

}
