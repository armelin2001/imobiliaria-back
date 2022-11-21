package com.br.imobiliaria.controllers;


import com.br.imobiliaria.controllers.docs.ImovelControllerDocs;
import com.br.imobiliaria.dto.request.ImovelCreateDTO;
import com.br.imobiliaria.services.ImovelService;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/imovel")
@Tag(name="imovel", description = "Endpoints de imoveis")
public class ImovelController implements ImovelControllerDocs {
    @Autowired
    private ImovelService imovelService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ImovelCreateDTO imovelCreateDTO){
        return imovelService.saveImovel(imovelCreateDTO);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return imovelService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable @NotNull String id){
        return imovelService.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id){
        return imovelService.remove(id);
    }

    @RequestMapping(value = "/aluga/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> aluga(@PathVariable("id") String id){
        return imovelService.aluga(id);
    }
}
