package com.example.PostWave.repository;

import com.example.PostWave.domain.Post;
import com.example.PostWave.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository <Post,String> {

    List<Post> findByTitleContainingIgnoreCase(String text);
}



