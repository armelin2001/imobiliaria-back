package com.br.imobiliaria.services;

import com.br.imobiliaria.dto.request.LoginDto;
import com.br.imobiliaria.dto.response.RetornoLogin;
import com.br.imobiliaria.entity.Cliente;
import com.br.imobiliaria.entity.Corretor;
import com.br.imobiliaria.repository.ClienteRepository;
import com.br.imobiliaria.repository.CorretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CorretorRepository corretorRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public ResponseEntity<?> realizaLogin(LoginDto login){
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(login.getEmail()).and("senha").is(login.getSenha()));
        List<Corretor> corretorList = mongoTemplate.find(query, Corretor.class);
        List<Cliente> clienteList =  mongoTemplate.find(query, Cliente.class);
        if(corretorList.isEmpty() && clienteList.isEmpty()){
            return new ResponseEntity<>("Senha ou email incorretos", HttpStatus.NOT_FOUND);
        }
        else{
            if(!corretorList.isEmpty()){
                Corretor corretor = corretorList.get(0);

                return new ResponseEntity<>(new RetornoLogin(
                        corretor.getId(),
                        corretor.getEmail(),
                        true)
                        , HttpStatus.OK);
            }
            Cliente cliente = clienteList.get(0);

            return new ResponseEntity<>(new RetornoLogin(
                    cliente.getId(),
                    cliente.getEmail(),
                    false), HttpStatus.OK);
        }
    }
}
