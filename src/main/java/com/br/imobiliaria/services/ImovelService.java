package com.br.imobiliaria.services;

import com.br.imobiliaria.dto.request.AlugaDto;
import com.br.imobiliaria.dto.request.ImovelCreateDTO;
import com.br.imobiliaria.dto.response.RetornoGenerico;
import com.br.imobiliaria.dto.response.RetornoGenericoErro;
import com.br.imobiliaria.dto.response.RetornoGenericoLista;
import com.br.imobiliaria.entity.Cliente;
import com.br.imobiliaria.entity.Corretor;
import com.br.imobiliaria.entity.Imovel;
import com.br.imobiliaria.repository.ClienteRepository;
import com.br.imobiliaria.repository.CorretorRepository;
import com.br.imobiliaria.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    @Autowired
    private CorretorRepository corretorRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public ResponseEntity<?> saveImovel(ImovelCreateDTO imovelCreateDTO){
        String idCorretor = imovelCreateDTO.getCorretorAnunciadoId();
        Optional<Corretor> corretor = corretorRepository
                .findById(idCorretor);
        if(!corretor.isEmpty()){
            Imovel imovelCreateParcial = new Imovel(imovelCreateDTO);
            imovelCreateParcial.setCorretorAnunciado(corretor.get());
            return new ResponseEntity<>( imovelRepository.save(imovelCreateParcial) , HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(
                    new RetornoGenericoErro("Imovel incorreto!"),
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public ResponseEntity<?> getById(String id){
        Optional<Imovel> imovelEncontrato = imovelRepository.findById(id);
        if(!imovelEncontrato.isEmpty()){
            return new ResponseEntity<>(imovelEncontrato.get() , HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(new RetornoGenericoErro("Imovel não encontrado"), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(imovelRepository.findAll() , HttpStatus.OK);
    }

    public ResponseEntity<?> remove(String id){
        Optional<Imovel> imovelEncontrato = imovelRepository.findById(id);
        if(!imovelEncontrato.isEmpty()){
            imovelRepository.deleteById(id);
            return new ResponseEntity<>(
                    new RetornoGenericoErro("Imovel removido com sucesso!"),
                    HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(
                    new RetornoGenericoErro("Imovel não encontrado!"),
                    HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<?> aluga(AlugaDto alugaDto){
        Optional<Imovel> imovelEncontrato = imovelRepository.findById(alugaDto.getIdImovel());
        Optional<Cliente> clienteEncontrado = clienteRepository.findById(alugaDto.getIdCliente());
        if(!imovelEncontrato.isEmpty() && !clienteEncontrado.isEmpty()){
            imovelEncontrato.get().setReservado(true);
            imovelEncontrato.get().setCliente(clienteEncontrado.get());
            imovelRepository.save(imovelEncontrato.get());
            return new ResponseEntity<>(imovelEncontrato.get() , HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(
                    new RetornoGenericoErro("Imovel não encontrado!"),
                    HttpStatus.NOT_FOUND);
        }
    }
}
