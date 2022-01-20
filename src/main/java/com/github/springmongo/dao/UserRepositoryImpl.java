package com.github.springmongo.dao;

import com.github.springmongo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springmongo
 */
public class UserRepositoryImpl implements MongoUserRepository{
    @Autowired
    MongoOperations mongoOperations;

    public List<User> findUsersPaging(int page, int size, String collection){
        Pageable pageableRequest;
        pageableRequest = PageRequest.of(page, size, Sort.Direction.DESC, "createdDate");
    return mongoOperations.find(new Query().with(pageableRequest), User.class,collection);
    }
}
