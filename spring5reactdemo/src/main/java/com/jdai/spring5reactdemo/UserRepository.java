package com.jdai.spring5reactdemo;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private Map<Integer, User> cache = new HashMap<Integer, User>(){{
        put(1, new User("user1"));
        put(2, new User("user2"));
    }};


    public Flux<User> users(){
        return Flux.fromIterable(cache.values());
    }


    public Mono<User> userById(int i){
        return Mono.justOrEmpty(cache.get(i));
    }
}
