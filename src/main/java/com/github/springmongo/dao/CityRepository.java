package com.github.springmongo.dao;

import com.github.springmongo.entities.City;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springmongo
 */
public interface CityRepository extends MongoRepository<City, String>, MongoCityRepository {
}
