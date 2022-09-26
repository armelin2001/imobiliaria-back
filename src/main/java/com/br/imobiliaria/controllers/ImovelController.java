package com.br.imobiliaria.controllers;


import com.br.imobiliaria.dto.request.ImovelCreateDTO;
import com.br.imobiliaria.services.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/imovel")
public class ImovelController {
    @Autowired
    private ImovelService imovelService;

    @PostMapping
    public ResponseEntity<?> saveImovel(@RequestBody ImovelCreateDTO imovelCreateDTO){
        return imovelService.saveImovel(imovelCreateDTO);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return imovelService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(String id){
        return imovelService.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id){
        return imovelService.remove(id);
    }

}
