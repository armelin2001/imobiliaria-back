package com.br.imobiliaria.services;

import com.br.imobiliaria.dto.request.CorretorCreateDto;
import com.br.imobiliaria.entity.Corretor;
import com.br.imobiliaria.repository.CorretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorretorService {

    @Autowired
    private CorretorRepository corretorRepository;

    public Corretor salvar(CorretorCreateDto corretor){
        Corretor corretorCreate = new Corretor(corretor);
        return corretorRepository.save(corretorCreate);
    }

    public List<Corretor> getAll(){
        return corretorRepository.findAll();
    }

    public Corretor getById(String id) throws Exception {
        Optional<Corretor> corretor = corretorRepository.findById(id);
        if(!corretor.isEmpty()){
            return corretor.get();
        }
        else {
            throw new Exception();
        }
    }
}
