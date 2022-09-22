package com.br.imobiliaria.controllers;

import com.br.imobiliaria.dto.request.ClienteCreateDTO;
import com.br.imobiliaria.dto.response.RetornoGenerico;
import com.br.imobiliaria.services.ClienteService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RetornoGenerico getById(@PathVariable @NotNull String id){
        return clienteService.getById(id);
    }

    @PostMapping
    public RetornoGenerico save(@RequestBody ClienteCreateDTO createClienteDTO) {
        return clienteService.saveCliente(createClienteDTO);
    }

}
