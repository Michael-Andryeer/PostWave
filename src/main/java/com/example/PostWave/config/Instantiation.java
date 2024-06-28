package com.example.PostWave.config;

import com.example.PostWave.domain.User;
import com.example.PostWave.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User vitoria = new User(null,"Vitoria carol","vitoria@gmail.com");
        User michael = new User(null,"Michael Andryeer","michael@gmail.com");
        User cadu = new User(null,"Cadu Andryeer Luz","caduzinhogamer@gmail.com");

       userRepository.saveAll(Arrays.asList(vitoria,michael,cadu));
    }
}
