package com.colak.springreactiveloggingtutorial.repository;

import com.colak.springreactiveloggingtutorial.jpa.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Long> {

    @Query("select * from users where age >= $1")
    Flux<User> findByAge(int age);
}
