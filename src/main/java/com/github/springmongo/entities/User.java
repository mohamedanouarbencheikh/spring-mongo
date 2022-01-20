package com.github.springmongo.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashMap;

/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springmongo
 */
@Document
@Getter
@Setter
@ToString
public class User{
    @Id
    private String id;
    private String username;
    private String password;
    private String name;
    private Date createdDate;

}
