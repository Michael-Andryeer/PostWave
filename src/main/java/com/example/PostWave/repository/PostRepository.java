package com.example.PostWave.repository;

import com.example.PostWave.domain.Post;
import com.example.PostWave.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository <Post,String> {
}



