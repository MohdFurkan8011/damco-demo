package com.damco.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.damco.demo.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}