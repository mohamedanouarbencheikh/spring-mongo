package com.github.springmongo.dao;

import com.github.springmongo.entities.City;

import java.util.List;

/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springmongo
 */
public interface MongoCityRepository {
    public List<City> findCityByCountry(String country, String collection);
    public List<City> findCityDynamicQuery(int population, double area, String collection);
}
