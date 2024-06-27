package com.example.PostWave.resources;

import com.example.PostWave.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User vitoria = new User("1","vitoria carol","vitoria@gmail.com");
        User michael = new User("2","michael andryeer","michael@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(vitoria,michael));
        return ResponseEntity.ok().body(list);
    }
}
