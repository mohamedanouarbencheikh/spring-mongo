package com.github.springmongo.dao;

import com.github.springmongo.entities.Society;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springmongo
 */
public interface SocietyRepository extends MongoRepository<Society, String>, MongoSocietyRepository {
}
