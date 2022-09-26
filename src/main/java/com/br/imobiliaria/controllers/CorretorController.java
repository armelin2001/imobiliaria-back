package com.br.imobiliaria.controllers;

import com.br.imobiliaria.dto.request.CorretorCreateDto;
import com.br.imobiliaria.dto.response.RetornoGenerico;
import com.br.imobiliaria.entity.Corretor;
import com.br.imobiliaria.services.CorretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corretor")
public class CorretorController {
    @Autowired
    private CorretorService corretorService;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody CorretorCreateDto corretor){
        return corretorService.salvar(corretor);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return corretorService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(String id){
        return corretorService.getById(id);
    }

}
