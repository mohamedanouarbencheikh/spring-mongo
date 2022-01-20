package com.github.springmongo.dao;

import com.github.springmongo.entities.User;

import java.util.List;

/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springmongo
 */
public interface MongoUserRepository {
    public List<User> findUsersPaging(int page, int size, String collection);
}
