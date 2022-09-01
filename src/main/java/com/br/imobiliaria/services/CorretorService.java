package com.br.imobiliaria.services;

import com.br.imobiliaria.entity.Corretor;
import com.br.imobiliaria.repository.CorretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorretorService {

    @Autowired
    private CorretorRepository corretorRepository;

    public Corretor salvar(Corretor corretor){
        return corretorRepository.save(corretor);
    }

    public List<Corretor> getAll(){
        return corretorRepository.findAll();
    }
}
