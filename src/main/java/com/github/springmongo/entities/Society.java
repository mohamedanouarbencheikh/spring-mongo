package com.github.springmongo.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springmongo
 */
@Document
@Getter
@Setter
@ToString
public class Society {
    @Id
    private String id;
    private String name;
    private HashMap<String,Direction> directions;
}
