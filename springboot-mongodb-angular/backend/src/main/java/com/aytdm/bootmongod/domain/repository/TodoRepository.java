package com.aytdm.bootmongod.domain.repository;

import com.aytdm.bootmongod.domain.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {

}