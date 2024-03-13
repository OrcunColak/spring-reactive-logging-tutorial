package com.colak.springreactiveloggingtutorial.jpa;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")

@Data
@Builder
public class User {
    @Id
    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    private int age;

    private double salary;

}
