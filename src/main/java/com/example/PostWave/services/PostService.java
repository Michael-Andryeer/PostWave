package com.example.PostWave.services;

import com.example.PostWave.domain.Post;
import com.example.PostWave.domain.User;
import com.example.PostWave.repository.PostRepository;
import com.example.PostWave.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
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

    public List<Post> findByTitle(String text) {
        return repository.findByTitleContainingIgnoreCase(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 *60 * 60 * 1000);
        return repository.fullSearch(text,minDate,maxDate);
    }
}
