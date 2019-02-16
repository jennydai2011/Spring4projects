package com.jdai.spring5reactdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public Flux<User> users(){
        return userRepository.users();
    }

    @GetMapping("/users/{id}")
    public Mono<User> userByid(@PathVariable Integer id){
        return userRepository.userById(id);
    }
}
