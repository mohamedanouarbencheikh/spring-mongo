package com.github.springmongo.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;

/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springmongo
 */
@Getter
@Setter
@ToString
public class Direction {
    private String name;
    private HashMap<String, Department> departments;
}
