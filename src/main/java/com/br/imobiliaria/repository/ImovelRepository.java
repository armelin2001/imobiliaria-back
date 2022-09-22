package com.br.imobiliaria.repository;

import com.br.imobiliaria.entity.Imovel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ImovelRepository extends MongoRepository<Imovel, String> {
}
