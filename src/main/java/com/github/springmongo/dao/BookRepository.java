package com.github.springmongo.dao;

import com.github.springmongo.entities.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springmongo
 */
public interface BookRepository extends MongoRepository<Book, String> {
}
