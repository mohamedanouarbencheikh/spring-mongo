package com.github.springmongo.dao;

import com.github.springmongo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springmongo
 */
public interface UserRepository extends MongoRepository<User, String>, MongoUserRepository {

    List<User> findByName(String name);
    Long countByName(String name);

    @Query(value = "{'name': ?0, 'username' : ?1}", fields = "{'password':0}")
    List<User> findByNameAndUsernameExcludePassWord(String name, String username);
}
