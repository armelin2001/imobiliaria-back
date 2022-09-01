package com.br.imobiliaria.repository;

import com.br.imobiliaria.entity.Corretor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CorretorRepository extends MongoRepository<Corretor, String> {
}
