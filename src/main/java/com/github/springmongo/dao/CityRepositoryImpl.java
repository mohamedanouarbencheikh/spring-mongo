package com.github.springmongo.dao;

import com.github.springmongo.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springmongo
 */
public class CityRepositoryImpl implements MongoCityRepository{

    @Autowired
    MongoOperations mongoOperations;

    public List<City> findCityByCountry(String country, String collection){
        return mongoOperations.find(new Query(Criteria.where("country.name").is(country)), City.class, collection);
    }

    public List<City> findCityDynamicQuery(int population, double area, String collection){

        List<Criteria> criteriaColonneAnd = new ArrayList<>();
        Criteria criteria = new Criteria();
        criteriaColonneAnd.add(Criteria.where("population").gt(population));
        criteriaColonneAnd.add(Criteria.where("area").gt(area));
        criteria.andOperator(criteriaColonneAnd.toArray(new Criteria[criteriaColonneAnd.size()]));

        return mongoOperations.find(new Query(criteria),City.class,collection);
    }
}
