package com.br.imobiliaria.services;

import com.br.imobiliaria.dto.request.ImovelCreateDTO;
import com.br.imobiliaria.dto.response.RetornoGenerico;
import com.br.imobiliaria.entity.Corretor;
import com.br.imobiliaria.entity.Imovel;
import com.br.imobiliaria.repository.CorretorRepository;
import com.br.imobiliaria.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    @Autowired
    private CorretorRepository corretorRepository;

    public RetornoGenerico saveImovel(ImovelCreateDTO imovelCreateDTO){
        String idCorretor = imovelCreateDTO.getCorretorAnunciadoId();
        Optional<Corretor> corretor = corretorRepository
                .findById(idCorretor);
        if(!corretor.isEmpty()){
            Imovel imovelCreateParcial = new Imovel(imovelCreateDTO);
            imovelCreateParcial.setCorretorAnunciado(corretor.get());
            return new RetornoGenerico(
                    "200",
                    imovelRepository.save(imovelCreateParcial)
            );
        }
        else {
            return new RetornoGenerico("404", "Corretor incorreto!");
        }
    }

    public RetornoGenerico getById(String id){
        Optional<Imovel> imovelEncontrato = imovelRepository.findById(id);
        if(!imovelEncontrato.isEmpty()){
            return new RetornoGenerico("200", imovelEncontrato);
        }
        else{
            return new RetornoGenerico("404", "Imovel não encontrado");
        }
    }

    public List<Imovel> getAll(){
        return imovelRepository.findAll();
    }

    public RetornoGenerico remove(String id){
        Optional<Imovel> imovelEncontrato = imovelRepository.findById(id);
        if(!imovelEncontrato.isEmpty()){
            imovelRepository.deleteById(id);
            return new RetornoGenerico("200", "Imovel removido com sucesso!");
        }
        else{
            return new RetornoGenerico("404", "Imovel não encontrado");
        }
    }

}
