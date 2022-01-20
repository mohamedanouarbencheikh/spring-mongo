package com.github.springmongo.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springmongo
 */
@Document
@Getter
@Setter
@ToString
public class City {
    @Id
    private String id;
    private String name;
    private Country country;
    private int population;
    private double area;
}
