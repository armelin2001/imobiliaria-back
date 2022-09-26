package com.br.imobiliaria.services;

import com.br.imobiliaria.dto.request.ClienteCreateDTO;
import com.br.imobiliaria.dto.response.RetornoGenerico;
import com.br.imobiliaria.entity.Cliente;
import com.br.imobiliaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ResponseEntity<?> saveCliente(ClienteCreateDTO clienteCreateDTO){
        Cliente clienteCreate = new Cliente(clienteCreateDTO);
        return new ResponseEntity<>( new RetornoGenerico(clienteRepository.save(clienteCreate)), HttpStatus.OK);
    }

    public ResponseEntity<?> getById(String id){
        boolean clienteEncontrado = clienteRepository.findById(id).isEmpty();
        if(!clienteEncontrado){
            return new ResponseEntity<>( new RetornoGenerico(clienteRepository.findById(id).get()), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>( new RetornoGenerico("Imovel não encontrado"), HttpStatus.NOT_FOUND);
        }
    }

}
