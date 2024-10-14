package com.colak.springtutorial.service;

import com.colak.springtutorial.jpa.User;
import com.colak.springtutorial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service

@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public Flux<User> findUsersByAge(int age) {
        log.info("findUsersByAge, age > {}", age);
        return userRepository.findByAge(age);
    }
}
