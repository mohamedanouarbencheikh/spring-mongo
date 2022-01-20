package com.github.springmongo.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springmongo
 */
@Document
@Getter
@Setter
@ToString
public class Author {
    private String id;
    private String name;
    @DBRef
    private Book book;

}
