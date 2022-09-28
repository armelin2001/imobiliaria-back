package com.br.imobiliaria.controllers;

import com.br.imobiliaria.controllers.docs.ClienteControllerDocs;
import com.br.imobiliaria.dto.request.ClienteCreateDTO;
import com.br.imobiliaria.services.ClienteService;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
@Tag(name="cliente", description = "Endpoints de clientes")
public class ClienteController implements ClienteControllerDocs {
    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?>  getById(@PathVariable @NotNull String id){
        return clienteService.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid ClienteCreateDTO createClienteDTO) {
        return clienteService.saveCliente(createClienteDTO);
    }

}
