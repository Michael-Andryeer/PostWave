package com.example.PostWave.services;

import com.example.PostWave.domain.Post;
import com.example.PostWave.domain.User;
import com.example.PostWave.repository.PostRepository;
import com.example.PostWave.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        Optional<Post> user = repository.findById(id);
        if(user.isEmpty())
            throw new ObjectNotFoundException("Objeto não encontrado");
        return user.orElse(null);
    }
}
