package com.example.PostWave.config;

import com.example.PostWave.domain.Post;
import com.example.PostWave.domain.User;
import com.example.PostWave.dto.AuthorDTO;
import com.example.PostWave.repository.PostRepository;
import com.example.PostWave.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User vitoria = new User(null,"Vitoria carol","vitoria@gmail.com");
        User michael = new User(null,"Michael Andryeer","michael@gmail.com");
        User cadu = new User(null,"Cadu Andryeer Luz","caduzinhogamer@gmail.com");

        userRepository.saveAll(Arrays.asList(vitoria,michael,cadu));

        Post post1 = new Post(null,sdf.parse("28/06/2024"),"Partiu Manaus","Vou viajar para Manaus", new AuthorDTO(vitoria) );
        Post post2 = new Post(null,sdf.parse("29/06/2024"),"Cheguei em Manaus","Finalmente cheguei em Manaus", new AuthorDTO(vitoria) );
        Post post3 = new Post(null,sdf.parse("25/06/2024"),"Bom dia","Acordei cedo!",  new AuthorDTO(michael));
        Post post4 = new Post(null,sdf.parse("25/06/2024"),"Academia","Indo para academia!!",  new AuthorDTO(michael));

        postRepository.saveAll(Arrays.asList(post1,post2,post3,post4));

        vitoria.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(vitoria);

        michael.getPosts().addAll(Arrays.asList(post3,post4));
        userRepository.save(michael);
    }
}
