package com.br.imobiliaria.repository;

import com.br.imobiliaria.entity.Imovel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImovelRepository extends MongoRepository<Imovel, String> {
}
