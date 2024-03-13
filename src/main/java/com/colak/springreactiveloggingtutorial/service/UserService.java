package com.colak.springreactiveloggingtutorial.service;

import com.colak.springreactiveloggingtutorial.jpa.User;
import com.colak.springreactiveloggingtutorial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service

@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Flux<User> findUsersByAge(int age) {
        log.info("findUsersByAge, age > {}", age);
        return userRepository.findByAge(age);
    }
}
