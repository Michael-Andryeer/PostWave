package com.example.PostWave.repository;

import com.example.PostWave.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository <User,String> {
}



