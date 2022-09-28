package com.br.imobiliaria.controllers;

import com.br.imobiliaria.controllers.docs.CorretorControllerDocs;
import com.br.imobiliaria.dto.request.CorretorCreateDto;
import com.br.imobiliaria.dto.response.RetornoGenerico;
import com.br.imobiliaria.entity.Corretor;
import com.br.imobiliaria.services.CorretorService;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corretor")
@Tag(name="corretor", description = "Endpoints de corretor de imovel")
public class CorretorController implements CorretorControllerDocs {
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
    public ResponseEntity<?> getById(@PathVariable("id") @NotNull String id){
        return corretorService.getById(id);
    }

}
