package com.github.springmongo.dao;

import com.github.springmongo.entities.Department;
import com.github.springmongo.entities.Direction;
import com.github.springmongo.entities.Employee;
import com.github.springmongo.entities.Society;

import java.util.List;

/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springmongo
 */
public interface MongoSocietyRepository {
   /* public List<Society> findSocietyByDirection(String direction);
    public List<Society> findSocietyByDirectionAndDepartement(String direction, String departement);
    public List<Society> findSocietyByDirectionAndDepartementAndEmployee(String direction, String departement, String employee);*/
   public List<Society> findSociety(String society);
   public void addUpdateEmployee(String society, String direction, String department, String nomEmployee, Employee employee, String collection);
   public void deleteEmployee(String society, String direction, String department, String nomEmployee, Employee employee, String collection);
   }
