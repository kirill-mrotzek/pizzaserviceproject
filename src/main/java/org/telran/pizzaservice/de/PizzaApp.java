package org.telran.pizzaservice.de;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //включает планировщик задач
public class PizzaApp {

   public static void main(String[] args) {
        SpringApplication.run(PizzaApp.class, args);
    }

}
