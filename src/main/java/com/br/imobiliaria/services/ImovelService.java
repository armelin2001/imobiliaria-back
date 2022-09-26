package com.br.imobiliaria.services;

import com.br.imobiliaria.dto.request.ImovelCreateDTO;
import com.br.imobiliaria.dto.response.RetornoGenerico;
import com.br.imobiliaria.entity.Corretor;
import com.br.imobiliaria.entity.Imovel;
import com.br.imobiliaria.repository.CorretorRepository;
import com.br.imobiliaria.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    @Autowired
    private CorretorRepository corretorRepository;

    public ResponseEntity<?> saveImovel(ImovelCreateDTO imovelCreateDTO){
        String idCorretor = imovelCreateDTO.getCorretorAnunciadoId();
        Optional<Corretor> corretor = corretorRepository
                .findById(idCorretor);
        if(!corretor.isEmpty()){
            Imovel imovelCreateParcial = new Imovel(imovelCreateDTO);
            imovelCreateParcial.setCorretorAnunciado(corretor.get());
            return new ResponseEntity<>( new RetornoGenerico(imovelRepository.save(imovelCreateParcial)), HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>( new RetornoGenerico("Imovel incorreto!"), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public ResponseEntity<?> getById(String id){
        Optional<Imovel> imovelEncontrato = imovelRepository.findById(id);
        if(!imovelEncontrato.isEmpty()){
            return new ResponseEntity<>( new RetornoGenerico(imovelEncontrato.get()), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>( new RetornoGenerico("Imovel não encontrado"), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>( new RetornoGenerico(imovelRepository.findAll()), HttpStatus.OK);
    }

    public ResponseEntity<?> remove(String id){
        Optional<Imovel> imovelEncontrato = imovelRepository.findById(id);
        if(!imovelEncontrato.isEmpty()){
            imovelRepository.deleteById(id);
            return new ResponseEntity<>( new RetornoGenerico("Imovel removido com sucesso!"), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>( new RetornoGenerico("Imovel não encontrado"), HttpStatus.NOT_FOUND);
        }
    }

}
