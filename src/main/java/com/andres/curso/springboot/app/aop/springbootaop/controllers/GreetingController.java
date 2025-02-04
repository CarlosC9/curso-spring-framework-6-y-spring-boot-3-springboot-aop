package com.andres.curso.springboot.app.aop.springbootaop.controllers;

import com.andres.curso.springboot.app.aop.springbootaop.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class GreetingController {

  private GreetingService greetingService;

  @Autowired
  public void setGreetingService(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  @GetMapping("/greeting")
  public ResponseEntity<?> greeting() {
    return ResponseEntity.ok(
      Collections.singletonMap("greeting", this.greetingService.sayHello("Pepe", "Hola que tal!")
      ));
  }

  @GetMapping("/greeting-error")
  public ResponseEntity<?> greetingError() {
    return ResponseEntity.ok(
      Collections.singletonMap("greeting", this.greetingService.sayHelloError("Pepe", "Hola que tal!")
      ));
  }

}
