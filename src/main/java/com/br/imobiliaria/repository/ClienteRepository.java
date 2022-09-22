package com.br.imobiliaria.repository;

import com.br.imobiliaria.entity.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ClienteRepository extends MongoRepository<Cliente, String> {
}
