package com.github.springmongo.dao;

import com.github.springmongo.entities.Direction;
import com.github.springmongo.entities.Employee;
import com.github.springmongo.entities.Society;
import com.github.springmongo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springmongo
 */
public class SocietyRepositoryImpl implements MongoSocietyRepository {

    @Autowired
    MongoOperations mongoOperations;

   /* public List<Society> findSocietyByDirection(String direction){
      //  return mongoOperations.find(new Query(Criteria.where("directions.name").is(direction)), Society.class, "society");
          return mongoOperations.find(new Query(Criteria.where("directions."+direction+".name").is(direction)), Society.class, "society");

    }
    public List<Society> findSocietyByDirectionAndDepartement(String direction, String departement){
        return mongoOperations.find(new Query(Criteria.where("directions."+direction+".departments."+departement+".name").is(departement)), Society.class, "society");
    }
    public List<Society> findSocietyByDirectionAndDepartementAndEmployee(String direction, String departement, String employee){
        return mongoOperations.find(new Query(Criteria.where("directions."+direction+".departments"+departement+".employees"+employee)), Society.class, "society");
    }*/

    public List<Society> findSociety(String society){
        return mongoOperations.find(new Query(Criteria.where("name").is(society)), Society.class, society);
    }

    public void addUpdateEmployee(String society, String direction, String department, String nomEmployee, Employee employee, String collection){
        mongoOperations.findAndModify(new Query(Criteria.where("name").is(society)), new Update().set("directions."+ direction + ".departments."+department+".employees."+nomEmployee, employee), Society.class, collection);
    }

    public void deleteEmployee(String society, String direction, String department, String nomEmployee, Employee employee, String collection){
        mongoOperations.findAndModify(new Query(Criteria.where("name").is(society)), new Update().unset("directions."+ direction + ".departments."+department+".employees."+nomEmployee), Society.class, collection);
    }

}
