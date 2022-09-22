package com.br.imobiliaria.controllers;


import com.br.imobiliaria.dto.request.ImovelCreateDTO;
import com.br.imobiliaria.dto.response.RetornoGenerico;
import com.br.imobiliaria.entity.Imovel;
import com.br.imobiliaria.services.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imovel")
public class ImovelController {
    @Autowired
    private ImovelService imovelService;

    @PostMapping
    public RetornoGenerico saveImovel(@RequestBody ImovelCreateDTO imovelCreateDTO){
        return imovelService.saveImovel(imovelCreateDTO);
    }

    @GetMapping
    public List<Imovel> getAll(){
        return imovelService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RetornoGenerico getById(String id){
        return imovelService.getById(id);
    }

    @DeleteMapping("/{id}")
    public RetornoGenerico delete(@PathVariable("id") String id){
        return imovelService.remove(id);
    }

}
