package com.br.imobiliaria.services;

import com.br.imobiliaria.dto.request.CorretorCreateDto;
import com.br.imobiliaria.dto.response.RetornoGenerico;
import com.br.imobiliaria.dto.response.RetornoGenericoErro;
import com.br.imobiliaria.dto.response.RetornoGenericoLista;
import com.br.imobiliaria.entity.Corretor;
import com.br.imobiliaria.repository.CorretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CorretorService {

    @Autowired
    private CorretorRepository corretorRepository;

    public ResponseEntity<?> salvar(CorretorCreateDto corretor){

        Corretor corretorCreate = new Corretor(corretor);
        RetornoGenerico ret = new RetornoGenerico();
        ret.setRetorno(corretorRepository.save(corretorCreate));
        return new ResponseEntity<>( ret, HttpStatus.CREATED);

    }

    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>( corretorRepository.findAll() , HttpStatus.OK);
    }

    public ResponseEntity<?> getById(String id){
        Optional<Corretor> corretor = corretorRepository.findById(id);
        if(!corretor.isEmpty()){
            return new ResponseEntity<>( corretor.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>( new RetornoGenericoErro("Corretor não encontrado"), HttpStatus.NOT_FOUND);
        }
    }
}
