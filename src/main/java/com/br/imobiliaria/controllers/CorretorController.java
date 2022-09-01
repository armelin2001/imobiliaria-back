package com.br.imobiliaria.controllers;

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

    /*@PostMapping
    public ResponseEntity<Corretor> salvar(@RequestBody Corretor corretor){
        corretor = corretorService.salvar(corretor);
        return new ResponseEntity<>(corretor, HttpStatus.CREATED);
    }*/

    @GetMapping
    public List<Corretor> getAll(){
        List<Corretor> corretores = corretorService.getAll();
        return corretores;
    }
}
