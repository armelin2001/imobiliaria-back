package com.br.imobiliaria.services;

import com.br.imobiliaria.dto.request.CorretorCreateDto;
import com.br.imobiliaria.dto.response.RetornoGenerico;
import com.br.imobiliaria.entity.Corretor;
import com.br.imobiliaria.repository.CorretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorretorService {

    @Autowired
    private CorretorRepository corretorRepository;

    public RetornoGenerico salvar(CorretorCreateDto corretor){
        Corretor corretorCreate = new Corretor(corretor);
        return new RetornoGenerico("201", corretorRepository.save(corretorCreate));
    }

    public List<Corretor> getAll(){
        return corretorRepository.findAll();
    }

    public RetornoGenerico getById(String id){
        boolean corretor = corretorRepository.findById(id).isEmpty();
        if(!corretor){
            return new RetornoGenerico("200", corretorRepository.findById(id));
        }
        else {
            return new RetornoGenerico("404", "Corretor não encontrado");
        }
    }
}
