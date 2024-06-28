package com.example.PostWave.services;

import com.example.PostWave.domain.User;
import com.example.PostWave.repository.UserRepository;
import com.example.PostWave.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> user = repository.findById(id);
        if(user.isEmpty())
            throw new ObjectNotFoundException("Objeto não encontrado");
        return user.orElse(null);
    }
}
