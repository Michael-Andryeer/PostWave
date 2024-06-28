package com.example.PostWave.services;

import com.example.PostWave.domain.User;
import com.example.PostWave.dto.UserDTO;
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

    public User insert(User obj) {
        return repository.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
    }
}
