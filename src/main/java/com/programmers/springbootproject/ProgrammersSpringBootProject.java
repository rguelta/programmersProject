package com.programmers.springbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for Programmer's spring boot project
 * 
 * @author Robin Delgado Guelta
 */
@SpringBootApplication(scanBasePackages = {"com.programmers.springbootproject.controller",
    "com.programmers.springbootproject.service"})
public class ProgrammersSpringBootProject {

  public static void main(String[] args) {
    SpringApplication.run(ProgrammersSpringBootProject.class, args);
  }
}
