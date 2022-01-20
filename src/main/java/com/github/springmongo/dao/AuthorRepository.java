package com.github.springmongo.dao;

import com.github.springmongo.entities.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springmongo
 */
public interface AuthorRepository extends MongoRepository<Author,String> {
    Author findOneByName(String name);
}
