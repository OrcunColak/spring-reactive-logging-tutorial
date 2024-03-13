package com.colak.springreactiveloggingtutorial.controller;

import com.colak.springreactiveloggingtutorial.jpa.User;
import com.colak.springreactiveloggingtutorial.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/v1/user")


@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // http://localhost:8080/v1/user/age/30
    @GetMapping("/age/{age}")
    public Flux<User> getUsersByAge(@PathVariable int age) {
        log.info("getUsersByAge, age > {}", age);
        return userService.findUsersByAge(age);
    }

}
